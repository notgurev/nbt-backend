package nbt.hack.nbtbackend.repositories

import nbt.hack.nbtbackend.model.CropField
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CropFieldRepository  : JpaRepository<CropField, Long> {

}