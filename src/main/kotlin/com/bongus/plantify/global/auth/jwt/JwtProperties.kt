package com.bongus.plantify.global.auth.jwt

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class JwtProperties (

    @Value("\${application.jwt.secretKey}") val secretKey: String,

    @Value("\${application.jwt.expiration}") val accessExpired: Long,

    @Value("\${application.jwt.refreshExpiration}") val refreshExpired: Long

)