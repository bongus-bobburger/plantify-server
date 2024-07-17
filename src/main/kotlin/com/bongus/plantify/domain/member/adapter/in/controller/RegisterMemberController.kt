package com.bongus.plantify.domain.member.adapter.`in`.controller

import com.bongus.plantify.domain.member.adapter.`in`.dto.req.RegisterMemberRequest
import com.bongus.plantify.domain.member.application.port.`in`.RegisterMemberUseCase
import com.bongus.plantify.global.auth.jwt.JwtInfo
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class RegisterMemberController (
    private val registerMemberUseCase: RegisterMemberUseCase
) {

    @PostMapping("/register")
    fun createMember(@RequestBody memberDTO: RegisterMemberRequest): BaseResponse<JwtInfo> {
        return registerMemberUseCase.registerMember(memberDTO)
    }

}