package nbt.hack.nbtbackend.controllers.dto

data class JwtResponse(val accessToken: String, val username: String, val tokenType: String = "Bearer")