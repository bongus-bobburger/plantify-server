package com.bongus.plantify.domain.member.adapter.out.repository

import com.bongus.plantify.domain.member.adapter.out.entity.MemberEntity

interface MemberRepositoryCustom {

    fun findByEmail(email: String): MemberEntity?

    fun existsByEmail(email: String): Boolean

}