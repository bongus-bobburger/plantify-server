package com.bongus.plantify.domain.member.application.service


import com.bongus.plantify.domain.member.adapter.`in`.dto.req.EditMemberRequest
import com.bongus.plantify.domain.member.adapter.out.MemberAdapter
import com.bongus.plantify.domain.member.application.port.`in`.EditMemberUseCase
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.stereotype.Service

@Service
class EditMemberService (
    private val memberAdapter: MemberAdapter,
) : EditMemberUseCase {

    override fun editMember(dto: EditMemberRequest, id: Long): BaseResponse<Unit> {
        val member = memberAdapter.loadMemberWithId(id)

        member.editMember(dto)

        memberAdapter.saveMember(member)

        return BaseResponse (
            message = "멤버 정보 변경 성공 !!"
        )
    }

}