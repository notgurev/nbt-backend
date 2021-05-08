package nbt.hack.nbtbackend.controllers

import nbt.hack.nbtbackend.model.CropField
import nbt.hack.nbtbackend.services.CropFieldService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cropFields")
class CropFieldController @Autowired constructor(
        val cropFieldService: CropFieldService,
){
    @GetMapping("/{id}")
    fun getCropField(@PathVariable id: Long): CropField{
        return cropFieldService.getCropField(id)
    }

    @GetMapping
    fun getAllCropFields(@RequestParam ownerUsername: String): List<CropField>{
        return cropFieldService.getAllCropFields(ownerUsername)
    }

    @PostMapping
    fun addCropField(ownerUsername: String){
        cropFieldService.addCropField(ownerUsername)
    }

    @PostMapping("/{id}")
    fun updateCropField(@PathVariable id: Long){
        cropFieldService.updateCropField(id)
    }

    @DeleteMapping("/{id}")
    fun deleteUsername(@PathVariable id: Long){
        cropFieldService.deleteUsername(id)
    }
}