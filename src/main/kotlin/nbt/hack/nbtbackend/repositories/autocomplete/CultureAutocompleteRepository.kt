package nbt.hack.nbtbackend.repositories.autocomplete

import nbt.hack.nbtbackend.model.autocomplete.CultureName
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CultureAutocompleteRepository : JpaRepository<CultureName, Long>