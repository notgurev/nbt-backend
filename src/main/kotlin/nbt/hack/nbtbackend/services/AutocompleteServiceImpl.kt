package nbt.hack.nbtbackend.services

import nbt.hack.nbtbackend.model.autocomplete.CultureName
import nbt.hack.nbtbackend.model.autocomplete.SoilName
import nbt.hack.nbtbackend.repositories.autocomplete.CultureAutocompleteRepository
import nbt.hack.nbtbackend.repositories.autocomplete.SoilAutocompleteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

// todo test

@Service
class AutocompleteServiceImpl @Autowired constructor(
    private val cultureAutocompleteRepository: CultureAutocompleteRepository,
    private val soilAutocompleteRepository: SoilAutocompleteRepository
) : AutocompleteService {
    override fun getCultures(prefix: String): List<String> {
        return cultureAutocompleteRepository.findAll().map { it.name }
    }

    override fun getSoils(prefix: String): List<String> {
        return soilAutocompleteRepository.findAll().map { it.name }
    }

    override fun addCulture(name: String) {
        cultureAutocompleteRepository.save(CultureName(name = name))
    }

    override fun addSoil(name: String) {
        soilAutocompleteRepository.save(SoilName(name = name))
    }
}