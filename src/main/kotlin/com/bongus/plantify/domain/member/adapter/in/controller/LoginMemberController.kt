package com.bongus.plantify.domain.member.adapter.`in`.controller

import com.bongus.plantify.domain.member.adapter.`in`.dto.req.LoginMemberRequest
import com.bongus.plantify.domain.member.application.port.`in`.LoginMemberUseCase
import com.bongus.plantify.global.auth.jwt.JwtInfo
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/member")
class LoginMemberController (
    private val loginMemberUseCase: LoginMemberUseCase
) {

    @PostMapping("/login")
    fun loginMember(@RequestBody memberDTO: LoginMemberRequest): BaseResponse<JwtInfo> {
        return loginMemberUseCase.loginMember(memberDTO)
    }

}