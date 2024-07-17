package com.bongus.plantify.domain.price.adaptor.`in`.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class PriceRequest(
    @NotBlank
    val name: String,
    @NotBlank
    val description: String,
    @NotNull
    val price: Int,
    @NotNull
    val imagePath: String
)
