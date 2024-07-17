package com.bongus.plantify.domain.community.adapter.out.repository

import com.bongus.plantify.domain.community.adapter.out.entity.CommunityEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CommunityRepository : JpaRepository<CommunityEntity, Long> {
    override fun findAll(): List<CommunityEntity>
    override fun findById(id: Long): Optional<CommunityEntity>
}