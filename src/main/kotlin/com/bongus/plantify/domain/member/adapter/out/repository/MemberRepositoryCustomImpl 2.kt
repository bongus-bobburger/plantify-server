//package com.bongus.plantify.domain.member.adapter.out.repository
//
//import com.bongus.plantify.domain.member.adapter.out.entity.MemberEntity
//import com.querydsl.jpa.impl.JPAQueryFactory
//import org.springframework.stereotype.Repository
//
//@Repository
//class MemberRepositoryCustomImpl (
//    private val jpaQueryFactory: JPAQueryFactory
//) : MemberRepositoryCustom {
//
//    override fun findByEmail(email: String): MemberEntity? {
//        val result = jpaQueryFactory
//            .select(memberEntity)
//            .from(memberEntity)
//            .where(
//                memberEntity.email.eq(email),
//                memberEntity.deleted.eq(false)
//            ).fetchOne()
//
//        return result
//    }
//
//    override fun existsByEmail(email: String): Boolean {
//
//        return jpaQueryFactory
//            .selectOne()
//            .from(memberEntity)
//            .where(
//                memberEntity.email.eq(email),
//                memberEntity.deleted.eq(false)
//            ).fetchOne() != null
//    }
//}