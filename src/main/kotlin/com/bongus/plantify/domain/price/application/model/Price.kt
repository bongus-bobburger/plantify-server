package com.bongus.plantify.domain.price.application.model

import com.bongus.plantify.domain.price.application.model.value.*

data class Price(
    val id: PriceId?,
    val priceName: PriceName,
    val description: PriceDescription,
    val pricePrice: PricePrice,
    val imageUrl: PriceImageUrl
){
    constructor(price: Price, userName: String) : this(
        id = PriceId(0),
        priceName = PriceName(price.priceName.value),
        description = PriceDescription(price.description.value),
        pricePrice = PricePrice(price.pricePrice.value),
        imageUrl = PriceImageUrl(price.imageUrl.value)
    )
}
