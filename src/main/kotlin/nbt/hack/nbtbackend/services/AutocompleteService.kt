package nbt.hack.nbtbackend.services

import org.springframework.stereotype.Component

@Component
interface AutocompleteService {
    fun getCultures(prefix: String?): List<String>

    fun getSoils(prefix: String): List<String>

    fun addCulture(name: String)

    fun addSoil(name: String)
}