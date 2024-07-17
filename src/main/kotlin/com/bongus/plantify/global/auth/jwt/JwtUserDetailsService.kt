package com.bongus.plantify.global.auth.jwt
import com.bongus.plantify.domain.member.application.port.out.LoadMemberPort
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class JwtUserDetailsService (
    private val loadMemberPort: LoadMemberPort
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        return JwtUserDetails (
            loadMemberPort.loadMemberWithEmail(email)
        )
    }
}