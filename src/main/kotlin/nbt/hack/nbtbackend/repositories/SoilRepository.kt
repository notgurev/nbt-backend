package nbt.hack.nbtbackend.repositories

import nbt.hack.nbtbackend.model.Soil
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SoilRepository : JpaRepository<Soil, Long> {
}