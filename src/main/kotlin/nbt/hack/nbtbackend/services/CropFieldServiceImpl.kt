package nbt.hack.nbtbackend.services

import nbt.hack.nbtbackend.model.CropField
import nbt.hack.nbtbackend.model.User
import nbt.hack.nbtbackend.repositories.CropFieldRepository
import nbt.hack.nbtbackend.repositories.UserRepository
import nbt.hack.nbtbackend.util.AUTH_CONTEXT
import nbt.hack.nbtbackend.util.maybeValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CropFieldServiceImpl @Autowired constructor(
    private val cropFieldRepository: CropFieldRepository,
    private val userRepository: UserRepository
) : CropFieldService {

    private fun checkIfExpert(): Boolean {
        return AUTH_CONTEXT.authorities.stream().anyMatch { it.authority == "expert" }
    }

    override fun getCropField(id: Long): CropField {
        val isExpert = checkIfExpert()
        val field: CropField = cropFieldRepository.findById(id).maybeValue
            ?: throw IllegalArgumentException("No crop field with id = $id")
        if (!isExpert && field.owner?.username != AUTH_CONTEXT.name) {
            throw IllegalAccessException("Only expert or owner can access this crop field")
        }
        return field
    }

    override fun getAllCropFields(ownerUsername: String): List<CropField> {
        val user = userRepository.findByUsername(ownerUsername)
        return user?.cropFields ?: throw IllegalArgumentException("No user with username = $ownerUsername")
    }

    override fun addCropField(ownerUsername: String, cropField: CropField) {
        val user: User = userRepository.findByUsername(ownerUsername)
            ?: throw IllegalArgumentException("No user with username = $ownerUsername")
        cropField.owner = user
        user.cropFields.add(cropField)
        cropFieldRepository.save(cropField)
        userRepository.save(user)
    }

    override fun updateCropField(id: Long, cropField: CropField) {
        if (!cropFieldRepository.existsById(id)) throw IllegalArgumentException("No field with id = $id")
        val field = cropFieldRepository.findById(id).maybeValue
        if (field?.owner?.username != AUTH_CONTEXT.name)
            throw IllegalAccessException("Only owner can access this crop field")
        cropField.id = id
        cropField.owner = field?.owner
        cropFieldRepository.save(cropField)
    }

    override fun deleteCropField(id: Long) {
        val field = cropFieldRepository.findById(id).maybeValue
            ?: throw IllegalArgumentException("No field with id = $id")
        if (field.owner?.username != AUTH_CONTEXT.name)
            throw IllegalAccessException("Only owner can access this crop field")
        field.owner?.cropFields?.remove(field)
        cropFieldRepository.deleteById(id)
    }
}