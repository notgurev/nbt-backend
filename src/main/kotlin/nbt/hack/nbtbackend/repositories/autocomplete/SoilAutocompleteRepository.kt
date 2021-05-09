package nbt.hack.nbtbackend.repositories.autocomplete

import nbt.hack.nbtbackend.model.autocomplete.SoilName
import nbt.hack.nbtbackend.util.AutocompleteRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SoilAutocompleteRepository : AutocompleteRepository<SoilName, Long>