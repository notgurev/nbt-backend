package nbt.hack.nbtbackend.configs

import nbt.hack.nbtbackend.model.User
import nbt.hack.nbtbackend.repositories.UserRepository
import nbt.hack.nbtbackend.services.AutocompleteService
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@PropertySource(value = ["classpath:/predefined.properties"], encoding = "UTF-8")
class Config {
    @Bean
    fun commandLineRunner(
        userRepository: UserRepository,
        encoder: PasswordEncoder,
        @Value("\${admin.password}") password: String,
        @Value("\${predefined.autocomplete.cultures}")
        cultures: Set<String>,
        @Value("\${predefined.autocomplete.soils}")
        soils: Set<String>,
        autocompleteService: AutocompleteService
    ): CommandLineRunner {
        return CommandLineRunner {
            // add admin on first boot
            if (!userRepository.existsByUsername("admin")) {
                val admin = User(username = "admin", password = encoder.encode(password))
                userRepository.save(admin)
            }

            // add predefined culture and soil names
            soils.forEach(autocompleteService::addSoil)
            cultures.forEach(autocompleteService::addCulture)
        }
    }
}