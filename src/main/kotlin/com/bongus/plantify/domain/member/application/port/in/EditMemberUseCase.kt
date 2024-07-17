package com.bongus.plantify.domain.member.application.port.`in`

import com.bongus.plantify.domain.member.adapter.`in`.dto.req.EditMemberRequest
import com.bongus.plantify.global.response.BaseResponse

interface EditMemberUseCase {

    fun editMember(dto: EditMemberRequest, id: Long): BaseResponse<Unit>

}