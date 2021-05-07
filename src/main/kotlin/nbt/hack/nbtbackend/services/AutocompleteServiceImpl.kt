package nbt.hack.nbtbackend.services

import org.springframework.stereotype.Service

// todo map cultures/soils to names

@Service
class AutocompleteServiceImpl : AutocompleteService {
    override fun getCultures(prefix: String): List<String> {
        TODO("Not yet implemented")
    }

    override fun getSoils(prefix: String): List<String> {
        TODO("Not yet implemented")
    }

}