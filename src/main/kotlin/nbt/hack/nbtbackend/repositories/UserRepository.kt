package nbt.hack.nbtbackend.repositories

import nbt.hack.nbtbackend.model.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository : JpaRepository<User, String?> {
    fun findByUsername(username: String): User?
    fun existsByUsername(username: String): Boolean
}