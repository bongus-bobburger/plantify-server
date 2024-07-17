package com.bongus.plantify.domain.community.adapter.`in`.controller

import com.bongus.plantify.domain.community.adapter.`in`.dto.req.CreateCommunityRequest
import com.bongus.plantify.domain.community.adapter.out.entity.CommunityEntity
import com.bongus.plantify.domain.community.application.service.CommunityService
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/community")
class CommunityController (
    private val communityService: CommunityService
){
    @GetMapping
    fun getAllCommunities(): BaseResponse<List<CommunityEntity>> {
        return communityService.findAll()
    }

    @PostMapping
    fun registerCommunity(request: CreateCommunityRequest): BaseResponse<Unit> {
        return communityService.register(request)
    }

}