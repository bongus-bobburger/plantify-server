package com.bongus.plantify.domain.member.application.service

import com.bongus.plantify.domain.member.adapter.`in`.dto.res.RetrieveMemberResponse
import com.bongus.plantify.domain.member.application.port.`in`.RetrieveMemberUseCase
import com.bongus.plantify.domain.member.application.port.out.LoadMemberPort
import com.bongus.plantify.domain.member.application.model.Member
import com.bongus.plantify.global.auth.jwt.JwtUtils
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.stereotype.Service

@Service
class RetrieveMemberService (
    private val loadMemberPort: LoadMemberPort,
    private val jwtUtils: JwtUtils
) : RetrieveMemberUseCase {

    override fun retrieveMember(): BaseResponse<RetrieveMemberResponse> {
        val member: Member = loadMemberPort.loadMemberWithId(jwtUtils.getMember().id!!.value)

        return BaseResponse (
            message = "멤버 정보 조회 성공 !!",
            data = RetrieveMemberResponse(member)
        )
    }
}