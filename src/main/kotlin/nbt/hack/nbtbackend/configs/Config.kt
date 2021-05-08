package nbt.hack.nbtbackend.configs

import nbt.hack.nbtbackend.model.User
import nbt.hack.nbtbackend.repositories.UserRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class Config {
    @Bean
    fun commandLineRunner(
        userRepository: UserRepository,
        encoder: PasswordEncoder,
        @Value("\${admin.password}") password: String
    ): CommandLineRunner {
        return CommandLineRunner {
            // add admin on first boot
            if (!userRepository.existsByUsername("admin")) {
                val admin = User(username = "admin", password = encoder.encode(password))
                userRepository.save(admin)
            }
        }
    }
}