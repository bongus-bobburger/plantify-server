package com.bongus.plantify.domain.member.application.service

import com.bongus.plantify.domain.member.adapter.`in`.dto.req.LoginMemberRequest
import com.bongus.plantify.domain.member.application.port.`in`.LoginMemberUseCase
import com.bongus.plantify.domain.member.application.port.out.LoadMemberPort
import com.bongus.plantify.domain.member.model.Member
import com.bongus.plantify.global.auth.exception.CustomException
import com.bongus.plantify.global.auth.jwt.JwtInfo
import com.bongus.plantify.global.auth.jwt.JwtUtils
import com.bongus.plantify.global.auth.jwt.exception.JwtErrorCode
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginMemberService(
    private val jwtUtils: JwtUtils,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val loadMemberPort: LoadMemberPort,
) : LoginMemberUseCase {

    override fun loginMember(memberDTO: LoginMemberRequest): BaseResponse<JwtInfo> {
        val member: Member = loadMemberPort.loadMemberWithEmail(memberDTO.email)

        if (!bCryptPasswordEncoder.matches(memberDTO.password, member.password.value)) {
            throw CustomException(JwtErrorCode.JWT_MEMBER_NOT_MATCH)
        }

        val jwtInfo = jwtUtils.generate(member)

        return BaseResponse (
            message = "토큰 발급 성공 !!",
            data = jwtInfo
        )
    }
}