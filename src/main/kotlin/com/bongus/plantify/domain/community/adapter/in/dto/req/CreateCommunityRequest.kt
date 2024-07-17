package com.bongus.plantify.domain.community.adapter.`in`.dto.req

import jakarta.validation.constraints.NotBlank

data class CreateCommunityRequest(
    @NotBlank(message = "Please enter title")
    val title: String,
    @NotBlank(message = "Please enter description")
    val description: String
)