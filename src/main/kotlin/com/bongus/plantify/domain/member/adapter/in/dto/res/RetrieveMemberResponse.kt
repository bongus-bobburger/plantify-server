package com.bongus.plantify.domain.member.adapter.`in`.dto.res

import com.bongus.plantify.domain.member.application.model.Member

data class RetrieveMemberResponse (

    val id: Long,
    val email: String,
    val name: String,

) {
    
    constructor (member: Member) : this (
        id = member.id!!.value,
        email = member.email.value,
        name = member.name.value,
    )

}