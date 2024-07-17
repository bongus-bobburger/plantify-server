package com.bongus.plantify.domain.member.application.port.`in`

import com.bongus.plantify.global.response.BaseResponse

interface RefreshTokenUseCase {

    fun refreshToken(token: String): BaseResponse<String>

}