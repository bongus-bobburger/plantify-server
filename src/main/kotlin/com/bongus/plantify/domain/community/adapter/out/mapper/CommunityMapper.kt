package com.bongus.plantify.domain.community.adapter.out.mapper

import com.bongus.plantify.domain.community.adapter.out.entity.CommunityEntity
import com.bongus.plantify.domain.community.application.model.Community
import org.springframework.stereotype.Component

@Component
class CommunityMapper {

    fun toEntity(domain: Community): CommunityEntity {
        return CommunityEntity (
            id = domain.id?.value ?: 0,
            title = domain.title.value,
            description = domain.description.value,
            imageUrl = domain.imageUrl.value,
            userName = domain.userName.value
        )
    }

}