package nbt.hack.nbtbackend.services

import nbt.hack.nbtbackend.model.CropField
import org.springframework.stereotype.Component

@Component
interface CropFieldService {
    fun getCropField(id: Long): CropField

    fun getAllCropFields(ownerUsername: String): List<CropField>

    fun deleteCropField(id: Long)

    fun addCropField(ownerUsername: String, cropField: CropField)

    fun updateCropField(id: Long, cropField: CropField)
}