package com.bongus.plantify.domain.member.adapter.`in`.controller

import com.bongus.plantify.domain.member.adapter.`in`.dto.res.RetrieveMemberResponse
import com.bongus.plantify.domain.member.application.port.`in`.RetrieveMemberUseCase
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class RetrieveMemberController (
    private val retrieveMemberUseCase: RetrieveMemberUseCase
) {

    @GetMapping("/myInfo")
    fun getMyInfo(memberId: Long): BaseResponse<RetrieveMemberResponse> {
        return retrieveMemberUseCase.retrieveMember(memberId)
    }

}