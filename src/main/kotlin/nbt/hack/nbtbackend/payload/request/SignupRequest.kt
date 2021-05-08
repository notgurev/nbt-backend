package nbt.hack.nbtbackend.payload.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


data class SignupRequest (
    var username: @NotBlank @Size(min = 3, max = 20) String,
    var password: @NotBlank @Size(min = 6, max = 20) String
)