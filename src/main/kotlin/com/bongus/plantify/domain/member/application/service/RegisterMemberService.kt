package com.bongus.plantify.domain.member.application.service

import com.bongus.plantify.domain.member.adapter.`in`.dto.req.RegisterMemberRequest
import com.bongus.plantify.domain.member.application.exception.MemberErrorCode
import com.bongus.plantify.domain.member.application.port.`in`.RegisterMemberUseCase
import com.bongus.plantify.domain.member.application.port.out.ExistMemberPort
import com.bongus.plantify.domain.member.application.port.out.SaveMemberPort
import com.bongus.plantify.domain.member.application.model.Member
import com.bongus.plantify.global.auth.exception.CustomException
import com.bongus.plantify.global.auth.jwt.JwtInfo
import com.bongus.plantify.global.auth.jwt.JwtUtils
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class RegisterMemberService(
    private val saveMemberPort: SaveMemberPort,
    private val existMemberPort: ExistMemberPort,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val jwtUtils: JwtUtils
) : RegisterMemberUseCase {

    override fun registerMember(@RequestBody dto: RegisterMemberRequest): BaseResponse<JwtInfo> {
        val member = Member(dto, bCryptPasswordEncoder.encode(dto.password))

        if (existMemberPort.existMemberWithEmail(member.email.value)) {
            throw CustomException(MemberErrorCode.MEMBER_ALREADY_EXIST)
        }

        saveMemberPort.saveMember(member)

        return BaseResponse(
            message = "회원가입 성공 !!",
            data = jwtUtils.generate(member)
        )
    }
}