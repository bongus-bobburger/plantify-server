package com.bongus.plantify.domain.member.application.port.out

import com.bongus.plantify.domain.member.model.Member

interface LoadMemberPort {

    fun loadMemberWithId(id: Long): Member

    fun loadMemberWithEmail(email: String): Member

}