package com.bongus.plantify.domain.price.application.model

import com.bongus.plantify.domain.price.adaptor.`in`.dto.PriceRequest
import com.bongus.plantify.domain.price.application.model.value.*

data class Price(
    val id: PriceId?,
    val priceName: PriceName,
    val description: PriceDescription,
    val pricePrice: PricePrice,
    val imageUrl: PriceImageUrl
){
    constructor(price: PriceRequest, userName: String) : this(
        id = PriceId(0),
        priceName = PriceName(price.name),
        description = PriceDescription(price.description),
        pricePrice = PricePrice(price.price),
        imageUrl = PriceImageUrl(price.imagePath)
    )
}
