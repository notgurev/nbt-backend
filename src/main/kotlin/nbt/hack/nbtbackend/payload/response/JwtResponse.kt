package nbt.hack.nbtbackend.payload.response


data class JwtResponse(var accessToken: String, var username: String) {
    var tokenType = "Bearer"
}