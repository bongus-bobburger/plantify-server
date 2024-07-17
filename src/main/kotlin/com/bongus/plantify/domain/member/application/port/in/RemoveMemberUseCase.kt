package com.bongus.plantify.domain.member.application.port.`in`

import com.bongus.plantify.global.response.BaseResponse

interface RemoveMemberUseCase {

    fun removeMember(id: Long) : BaseResponse<Unit>

}