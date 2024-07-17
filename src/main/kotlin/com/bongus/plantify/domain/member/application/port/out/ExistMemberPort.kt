package com.bongus.plantify.domain.member.application.port.out


interface ExistMemberPort {

    fun existMemberWithEmail(email: String): Boolean

}