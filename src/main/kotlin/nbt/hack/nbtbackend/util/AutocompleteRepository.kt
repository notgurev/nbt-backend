package nbt.hack.nbtbackend.util

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AutocompleteRepository<T, ID> : JpaRepository<T, ID> {
    fun findByNameStartingWith(prefix: String) // todo limit
}