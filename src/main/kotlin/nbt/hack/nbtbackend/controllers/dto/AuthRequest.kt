package nbt.hack.nbtbackend.controllers.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AuthRequest(
    @NotBlank @Size(min = 3, max = 20) val username: String,
    @NotBlank @Size(min = 3, max = 20) val password: String
)