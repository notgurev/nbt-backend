package nbt.hack.nbtbackend.services

import nbt.hack.nbtbackend.model.User
import nbt.hack.nbtbackend.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

typealias SpringUser = org.springframework.security.core.userdetails.User

@Service
class UserDetailsServiceImpl @Autowired constructor(
        val userRepository: UserRepository
) : UserDetailsService {
    @Transactional(readOnly = true)
    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = userRepository.findByUsername(username)
                ?: throw UsernameNotFoundException("User Not Found with username: $username")
        val grantedAuthorities: MutableSet<GrantedAuthority> = HashSet()
        if (user.isExpert) grantedAuthorities.add(SimpleGrantedAuthority("expert"))
        else grantedAuthorities.add(SimpleGrantedAuthority("user"))
        return SpringUser(user.username, user.password, grantedAuthorities)
    }
}