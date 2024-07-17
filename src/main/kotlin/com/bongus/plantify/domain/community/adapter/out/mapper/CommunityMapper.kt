package com.bongus.plantify.domain.community.adapter.out.mapper

import com.bongus.plantify.domain.community.adapter.out.entity.CommunityEntity
import com.bongus.plantify.domain.community.application.model.Community
import org.springframework.stereotype.Component

@Component
class CommunityMapper {

    fun toDomain(entity: Community): Community {
        return Community(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            userId = entity.userId,
            createdDate = entity.createdDate,
            lastModifiedDate = entity.lastModifiedDate,
        )
    }

    fun toEntity(domain: Community): CommunityEntity {
        return CommunityEntity (
            id = domain.id?.value ?: 0,
            title = domain.title.value,
            description = domain.description.value,
            userId = domain.userId.value,
            createdDate = domain.createdDate.value,
            lastModifiedDate = domain.lastModifiedDate.value,
        )
    }

}