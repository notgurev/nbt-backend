package nbt.hack.nbtbackend.controllers

import nbt.hack.nbtbackend.services.AutocompleteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// todo disable security
// todo test with prefix == ""

@RestController("/api/autocomplete")
class AutocompleteController @Autowired constructor(
    private val autocompleteService: AutocompleteService
) {
    @GetMapping("cultures")
    fun getCultureNames(@RequestParam prefix: String): List<String> {
        return autocompleteService.getCultures(prefix)
    }

    @GetMapping("soils")
    fun getSoilNames(@RequestParam prefix: String): List<String> {
        return autocompleteService.getSoils(prefix)
    }
}