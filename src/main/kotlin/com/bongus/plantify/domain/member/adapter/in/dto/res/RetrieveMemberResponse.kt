package com.bongus.plantify.domain.member.adapter.`in`.dto.res

import com.bongus.plantify.domain.member.model.Member

data class RetrieveMemberResponse (

    val id: Long,
    val email: String,
    val birth: String,
    val name: String,
    val picture: String,

) {
    
    constructor (member: Member) : this (
        id = member.id!!.value,
        email = member.email.value,
        birth = member.birth.value,
        name = member.name.value,
        picture = member.picture.value
    )

}