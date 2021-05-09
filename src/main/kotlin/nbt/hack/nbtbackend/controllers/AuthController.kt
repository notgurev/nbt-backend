package nbt.hack.nbtbackend.controllers

import nbt.hack.nbtbackend.controllers.dto.AuthRequest
import nbt.hack.nbtbackend.model.User
import nbt.hack.nbtbackend.controllers.dto.JwtResponse
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

typealias SpringUser = org.springframework.security.core.userdetails.User

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/api/auth")
class AuthController @Autowired constructor(
    val authenticationManager: AuthenticationManager,
    val userRepository: UserRepository,
    val encoder: PasswordEncoder,
    val jwtUtils: JwtUtils
) {
    private fun responseToken(username: String, password: String): ResponseEntity<JwtResponse> {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(username, password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        val token = jwtUtils.generateJwtToken(authentication)
        val user = authentication.principal as SpringUser
        return ResponseEntity.ok(JwtResponse(token, user.username))
    }

    @PostMapping("/signin")
    fun authenticateUser(@RequestBody @Valid authRequest: AuthRequest): ResponseEntity<JwtResponse> {
        return responseToken(authRequest.username, authRequest.password)
    }

    @PostMapping("/signup")
    fun registerUser(@RequestBody @Valid authRequest: AuthRequest): ResponseEntity<JwtResponse> {
        val (username, password) = authRequest
        if (userRepository.existsByUsername(username)) {
            throw IllegalArgumentException("Error: username is already taken!")
        }
        val user = User(username = username, password = encoder.encode(password))
        userRepository.save(user)
        return responseToken(username, password)
    }
}