package com.bongus.plantify.domain.community.application.model

import com.bongus.plantify.domain.community.adapter.`in`.dto.req.CreateCommunityRequest
import com.bongus.plantify.domain.community.application.model.value.*
import java.time.LocalDateTime

data class Community (

    val id: CommunityId?,
    val title: CommunityTitle,
    val description: CommunityDescription,
    val imageUrl: CommunityImageUrl,
    val userId: CommunityUserId,
    val createdDate: CommunityCreatedDate,
    val lastModifiedDate: CommunityLastModifiedDate

){

    /*TODO constructor*/
    constructor(request: CreateCommunityRequest, userId: Long) : this (
        id = CommunityId(0),
        title = CommunityTitle(request.title),
        description = CommunityDescription(request.description),
        imageUrl = CommunityImageUrl(request.imageUrl),
        userId = CommunityUserId(userId),
        createdDate = CommunityCreatedDate(LocalDateTime.now()),
        lastModifiedDate = CommunityLastModifiedDate(LocalDateTime.now())
    )

}