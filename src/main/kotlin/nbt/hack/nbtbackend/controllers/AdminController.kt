package nbt.hack.nbtbackend.controllers

import nbt.hack.nbtbackend.model.User
import nbt.hack.nbtbackend.repositories.UserRepository
import nbt.hack.nbtbackend.util.AUTH_CONTEXT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

// todo better code, less copy-paste

@RestController
@RequestMapping("/api/admin")
class AdminController @Autowired constructor(
    private val userRepository: UserRepository
) {
    @PostMapping("/experts")
    fun addExpert(@RequestParam username: String) {
        if (AUTH_CONTEXT.name != "admin") throw IllegalAccessException("Only for admin") // todo role
        val user: User = userRepository.findByUsername(username)
            ?: throw IllegalArgumentException("No user with username $username")
        user.isExpert = true
        userRepository.save(user)
    }

    @DeleteMapping("/experts")
    fun removeExpert(@RequestParam username: String) {
        if (AUTH_CONTEXT.name != "admin") throw IllegalAccessException("Only for admin") // todo role
        val user: User = userRepository.findByUsername(username)
            ?: throw IllegalArgumentException("No user with username $username")
        user.isExpert = false
        userRepository.save(user)
    }
}