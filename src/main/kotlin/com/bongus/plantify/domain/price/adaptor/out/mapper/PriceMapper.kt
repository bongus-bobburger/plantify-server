package com.bongus.plantify.domain.price.adaptor.out.mapper

import com.bongus.plantify.domain.price.adaptor.out.entity.PriceEntity
import com.bongus.plantify.domain.price.application.model.Price
import org.springframework.stereotype.Component

@Component
class PriceMapper {
    fun toEntity(domain: Price) : PriceEntity {
        return PriceEntity(
            id = domain.id?.value ?: null,
            name = domain.priceName.value,
            description = domain.description.value,
            price = domain.pricePrice.value,
            imageUrl = domain.imageUrl.value
        )
    }
}