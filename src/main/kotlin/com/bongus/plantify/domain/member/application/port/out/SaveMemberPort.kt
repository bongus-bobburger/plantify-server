package com.bongus.plantify.domain.member.application.port.out

import com.bongus.plantify.domain.member.application.model.Member

interface SaveMemberPort {

    fun saveMember(member: Member)

}