package com.bongus.plantify.domain.community.application.service

import com.bongus.plantify.domain.community.adapter.`in`.dto.req.CreateCommunityRequest
import com.bongus.plantify.domain.community.adapter.out.entity.CommunityEntity
import com.bongus.plantify.domain.community.adapter.out.mapper.CommunityMapper
import com.bongus.plantify.domain.community.adapter.out.repository.CommunityRepository
import com.bongus.plantify.domain.community.application.model.Community
import com.bongus.plantify.global.auth.jwt.JwtUtils
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class CommunityService (
    private val repository: CommunityRepository,
    private val mapper: CommunityMapper,
    private val jwtUtils: JwtUtils
){
    @Transactional(readOnly = true)
    fun findAll(): BaseResponse<List<CommunityEntity>>{
        return BaseResponse(
            message = "조회 성공 !!",
            data = repository.findAll()
        )
    }

    fun register(communityRequest: CreateCommunityRequest): BaseResponse<Unit>{
        repository.save(
            mapper.toEntity(
                Community(
                    communityRequest, jwtUtils.getMember().name.value
                )
            )
        )
        return BaseResponse(
            message = "생성 성공 와 대박!!"
        )
    }

}