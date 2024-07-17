package com.bongus.plantify.domain.member.application.port.`in`

import com.bongus.plantify.domain.member.adapter.`in`.dto.req.RegisterMemberRequest
import com.bongus.plantify.global.auth.jwt.JwtInfo
import com.bongus.plantify.global.response.BaseResponse

interface RegisterMemberUseCase {

    fun registerMember(dto: RegisterMemberRequest): BaseResponse<JwtInfo>

}