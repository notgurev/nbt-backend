package nbt.hack.nbtbackend.controllers

import nbt.hack.nbtbackend.payload.request.LoginRequest
import nbt.hack.nbtbackend.payload.request.SignupRequest
import nbt.hack.nbtbackend.payload.response.JwtResponse
import nbt.hack.nbtbackend.payload.response.MessageResponse
import nbt.hack.nbtbackend.repositories.UserRepository
import nbt.hack.nbtbackend.sequrity.jwt.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import nbt.hack.nbtbackend.model.User

typealias SpringUser = org.springframework.security.core.userdetails.User

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/api/auth")
class AuthController @Autowired constructor(
        var authenticationManager: AuthenticationManager,
        var userRepository: UserRepository,
        var encoder: PasswordEncoder,
        var jwtUtils: JwtUtils
) {
    @PostMapping("/signin")
    fun authenticateUser(@RequestBody loginRequest: @Valid LoginRequest): ResponseEntity<*> {
        val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password))
        SecurityContextHolder.getContext().authentication = authentication
        val jwt = jwtUtils.generateJwtToken(authentication)
        val user = authentication.principal as SpringUser
        return ResponseEntity.ok<Any>(JwtResponse(jwt, user.username))
    }

    @PostMapping("/signup")
    fun registerUser(@RequestBody signUpRequest: @Valid SignupRequest): ResponseEntity<*> {
        if (userRepository.existsByUsername(signUpRequest.username)!!) {
            return ResponseEntity
                    .badRequest()
                    .body<Any>(MessageResponse("Error: Username is already taken!"))
        }
        val user = User()
        user.username = signUpRequest.username
        user.password = encoder.encode(signUpRequest.password)
        userRepository.save<User>(user)
        return ResponseEntity.ok<Any>(MessageResponse("User registered successfully!"))
    }
}