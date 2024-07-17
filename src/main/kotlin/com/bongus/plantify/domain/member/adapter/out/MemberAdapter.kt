package com.bongus.plantify.domain.member.adapter.out

import com.bongus.plantify.domain.member.adapter.out.mapper.MemberMapper
import com.bongus.plantify.domain.member.adapter.out.repository.MemberRepository
import com.bongus.plantify.domain.member.application.exception.MemberErrorCode
import com.bongus.plantify.domain.member.application.port.out.ExistMemberPort
import com.bongus.plantify.domain.member.application.port.out.LoadMemberPort
import com.bongus.plantify.domain.member.application.port.out.SaveMemberPort
import com.bongus.plantify.domain.member.application.model.Member
import com.bongus.plantify.global.auth.exception.CustomException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MemberAdapter (
    val memberRepository: MemberRepository,
    val memberMapper: MemberMapper
) : SaveMemberPort, LoadMemberPort, ExistMemberPort {

    @Transactional
    override fun saveMember(member: Member) {
        memberRepository.save(
            memberMapper.toEntity(member)
        )
    }

    @Transactional(readOnly= true)
    override fun loadMemberWithId(id: Long): Member {
        return memberMapper.toDomain(
            memberRepository.findByIdOrNull(id)
                ?: throw CustomException(MemberErrorCode.MEMBER_NOT_FOUND)
        )
    }

    @Transactional(readOnly = true)
    override fun loadMemberWithEmail(email: String): Member {
        return memberMapper.toDomain(
            memberRepository.findByEmail(email)
                ?: throw CustomException(MemberErrorCode.MEMBER_NOT_FOUND)
        )
    }

    @Transactional(readOnly = true)
    override fun existMemberWithEmail(email: String): Boolean {
        return memberRepository.existsByEmail(email)
    }
}