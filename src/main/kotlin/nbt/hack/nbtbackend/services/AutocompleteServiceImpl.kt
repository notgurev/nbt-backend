package nbt.hack.nbtbackend.services

import nbt.hack.nbtbackend.model.autocomplete.CultureName
import nbt.hack.nbtbackend.model.autocomplete.SoilName
import nbt.hack.nbtbackend.repositories.autocomplete.CultureAutocompleteRepository
import nbt.hack.nbtbackend.repositories.autocomplete.SoilAutocompleteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AutocompleteServiceImpl @Autowired constructor(
    private val cultureAutocompleteRepository: CultureAutocompleteRepository,
    private val soilAutocompleteRepository: SoilAutocompleteRepository
) : AutocompleteService {
    override fun getCultures(prefix: String?): List<String> {
        val cultures = if (prefix == null) {
            cultureAutocompleteRepository.findAll()
        } else {
            cultureAutocompleteRepository.findAllByNameStartingWith(prefix)
        }
        return cultures.map { it.name }
    }

    override fun getSoils(prefix: String): List<String> {
        return soilAutocompleteRepository.findAllByNameStartingWith(prefix).map { it.name }
    }

    override fun addCulture(name: String) {
        if (!cultureAutocompleteRepository.existsByName(name)) {
            cultureAutocompleteRepository.save(CultureName(name = name))
        }
    }

    override fun addSoil(name: String) {
        if (!soilAutocompleteRepository.existsByName(name)) {
            soilAutocompleteRepository.save(SoilName(name = name))
        }
    }
}