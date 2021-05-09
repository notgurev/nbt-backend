package nbt.hack.nbtbackend.util

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AutocompleteRepository<T, ID> : JpaRepository<T, ID> {
    fun findAllByNameStartingWith(prefix: String): List<T>
    fun existsByName(name: String): Boolean
}