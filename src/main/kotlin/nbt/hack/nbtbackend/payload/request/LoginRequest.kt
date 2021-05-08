package nbt.hack.nbtbackend.payload.request

import javax.validation.constraints.NotBlank


data class LoginRequest (
    var username: @NotBlank String,
    var password: @NotBlank String
)