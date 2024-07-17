package com.bongus.plantify.global.auth.jwt

import com.bongus.plantify.domain.member.application.model.value.MemberId
import com.bongus.plantify.domain.member.application.model.Member
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class JwtUserDetails(
    val member: Member
) : UserDetails {

    val id: MemberId? = member.id

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities: MutableCollection<GrantedAuthority> = ArrayList()

        authorities.add(SimpleGrantedAuthority(member.role.value))

        return authorities
    }

    override fun getPassword(): String {
        return member.password.value
    }

    override fun getUsername(): String {
        return member.name.value
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}