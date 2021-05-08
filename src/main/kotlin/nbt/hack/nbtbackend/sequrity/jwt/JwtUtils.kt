package nbt.hack.nbtbackend.sequrity.jwt

import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import java.security.SignatureException
import java.util.*


@Component
class JwtUtils {
    @Value("\${app.jwtSecret}")
    private val jwtSecret: String? = null

    @Value("\${app.jwtExpirationMs}")
    private val jwtExpirationMs = 0
    fun generateJwtToken(authentication: Authentication): String {
        val userPrincipal = authentication.principal as User
        return Jwts.builder().setSubject(userPrincipal.username).setIssuedAt(Date())
                .setExpiration(Date(Date().time + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact()
    }

    fun getUserNameFromJwtToken(token: String?): String {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject()
    }

    fun validateJwtToken(authToken: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken)
            true
        } catch (e: SignatureException) {
            false
        } catch (e: MalformedJwtException) {
            false
        } catch (e: ExpiredJwtException) {
            false
        } catch (e: UnsupportedJwtException) {
            false
        } catch (e: IllegalArgumentException) {
            false
        }
    }
}