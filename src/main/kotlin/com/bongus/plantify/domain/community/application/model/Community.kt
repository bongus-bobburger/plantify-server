package com.bongus.plantify.domain.community.application.model

import com.bongus.plantify.domain.community.adapter.`in`.dto.req.CreateCommunityRequest
import java.util.*

data class Community (

    val id: Long?,
    var title: String?,
    var description: String?,
    val userId: Long?,
    val createdDate: Date?,
    var lastModifiedDate: Date?

){

    /*TODO constructor*/
    constructor(request: CreateCommunityRequest, userId: Long?) : this (
        id = null,
        title = request.title.toString(),
        description = request.description.toString(),
        userId = userId,
        createdDate = Date(),
        lastModifiedDate = Date()
    )

}