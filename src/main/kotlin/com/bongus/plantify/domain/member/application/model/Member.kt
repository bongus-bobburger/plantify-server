package com.bongus.plantify.domain.member.application.model

import com.bongus.plantify.domain.member.adapter.`in`.dto.req.EditMemberRequest
import com.bongus.plantify.domain.member.adapter.`in`.dto.req.RegisterMemberRequest
import com.bongus.plantify.domain.member.application.model.value.*

data class Member (

    val id: MemberId?,
    var name: MemberName,
    val email: MemberEmail,
    val password: MemberPassword,
    val role: MemberRole,
    var deleted: MemberDeleted

) {

    constructor(dto: RegisterMemberRequest, encrypted: String) : this (
        id = MemberId(0),
        name = MemberName(dto.name),
        email = MemberEmail(dto.email),
        password = MemberPassword(encrypted),
        role = MemberRole("ROLE_USER"),
        deleted = MemberDeleted(false)
    )

    fun editMember (dto: EditMemberRequest) {
        this.name = MemberName(dto.name)
    }

}