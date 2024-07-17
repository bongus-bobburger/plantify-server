package com.bongus.plantify.domain.member.adapter.`in`.controller

import com.bongus.plantify.domain.member.application.port.`in`.RefreshTokenUseCase
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class RefreshTokenController (
    private val refreshTokenUseCase: RefreshTokenUseCase
) {

    @GetMapping("/refresh")
    fun refreshToken(token: String): BaseResponse<String> {
        return refreshTokenUseCase.refreshToken(token)
    }

}