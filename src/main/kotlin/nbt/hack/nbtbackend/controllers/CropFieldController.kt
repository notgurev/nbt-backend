package nbt.hack.nbtbackend.controllers

import nbt.hack.nbtbackend.model.CropField
import nbt.hack.nbtbackend.services.CropFieldService
import nbt.hack.nbtbackend.util.AUTH_CONTEXT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cropFields")
class CropFieldController @Autowired constructor(
    private val cropFieldService: CropFieldService,
) {
    @GetMapping("/{id}")
    // any role
    fun getCropField(@PathVariable id: Long): CropField {
        return cropFieldService.getCropField(id)
    }

    @GetMapping
    @PreAuthorize("hasAuthority('user')")
    fun getAllCropFields(): List<CropField> {
        return cropFieldService.getAllCropFields(AUTH_CONTEXT.name)
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user')")
    fun addCropField(@RequestBody cropField: CropField): Long {
        return cropFieldService.addCropField(AUTH_CONTEXT.name, cropField)
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('user')")
    fun updateCropField(@PathVariable id: Long, @RequestBody cropField: CropField) {
        cropFieldService.updateCropField(id, cropField)
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user')")
    fun deleteCropField(@PathVariable id: Long) {
        cropFieldService.deleteCropField(id)
    }
}