package nbt.hack.nbtbackend.repositories

import nbt.hack.nbtbackend.model.Culture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CultureRepository : JpaRepository<Culture, Long> {
}