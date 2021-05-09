package nbt.hack.nbtbackend.repositories.autocomplete

import nbt.hack.nbtbackend.model.autocomplete.CultureName
import nbt.hack.nbtbackend.services.AutocompleteService
import nbt.hack.nbtbackend.util.AutocompleteRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CultureAutocompleteRepository : AutocompleteRepository<CultureName, Long>