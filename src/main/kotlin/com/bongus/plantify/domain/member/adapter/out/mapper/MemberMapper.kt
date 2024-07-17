package com.bongus.plantify.domain.member.adapter.out.mapper

import com.bongus.plantify.domain.member.adapter.out.entity.MemberEntity
import com.bongus.plantify.domain.member.application.model.value.*
import com.bongus.plantify.domain.member.application.model.Member
import org.springframework.stereotype.Component

@Component
class MemberMapper{

    fun toDomain(entity: MemberEntity): Member {
        return Member (
            id = MemberId(entity.id!!),
            name = MemberName(entity.name),
            email = MemberEmail(entity.email),
            password = MemberPassword(entity.password),
            role = MemberRole(entity.role),
            deleted = MemberDeleted(entity.deleted)
        )
    }

    fun toEntity(domain: Member): MemberEntity {
        return MemberEntity (
            id = domain.id?.value ?: 0,
            name = domain.name.value,
            email = domain.email.value,
            password = domain.password.value,
            deleted = domain.deleted.value
        )
    }

}