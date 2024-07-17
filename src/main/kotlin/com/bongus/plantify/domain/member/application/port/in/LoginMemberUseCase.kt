package com.bongus.plantify.domain.member.application.port.`in`

import com.bongus.plantify.domain.member.adapter.`in`.dto.req.LoginMemberRequest
import com.bongus.plantify.global.auth.jwt.JwtInfo
import com.bongus.plantify.global.response.BaseResponse

interface LoginMemberUseCase {

    fun loginMember(memberDTO: LoginMemberRequest): BaseResponse<JwtInfo>

}