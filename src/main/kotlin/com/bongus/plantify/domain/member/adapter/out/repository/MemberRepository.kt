package com.bongus.plantify.domain.member.adapter.out.repository

import com.bongus.plantify.domain.member.adapter.out.entity.MemberEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: CrudRepository<MemberEntity, Long>, MemberRepositoryCustom {

    override fun findByEmail(email: String): MemberEntity?

    override fun existsByEmail(email: String): Boolean

}