package com.bongus.plantify.domain.community.adapter.`in`.dto.req

import jakarta.validation.constraints.NotBlank

class CreateCommunityRequest(
    @NotBlank(message = "Please enter title")
    val title: String,
    val imageUrl: String,
    @NotBlank(message = "Please enter description")
    val description: String
)