package com.bongus.plantify.domain.community.adapter.out.mapper

import com.bongus.plantify.domain.community.application.model.Community
import org.springframework.stereotype.Component

@Component
class CommunityMapper {

    fun toDomain(community: Community): Community {
        return Community(
            id = community.id,
            title = community.title,
            description = community.description,
            userId = community.userId,
            createdDate = community.createdDate,
            lastModifiedDate = community.lastModifiedDate,
        )
    }



}