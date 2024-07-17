package com.bongus.plantify.domain.member.application.port.`in`

import com.bongus.plantify.domain.member.adapter.`in`.dto.res.RetrieveMemberResponse
import com.bongus.plantify.global.response.BaseResponse

interface RetrieveMemberUseCase {

    fun retrieveMember(memberId: Long): BaseResponse<RetrieveMemberResponse>

}