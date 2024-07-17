package com.bongus.plantify.domain.community.adapter.`in`.dto.req

import jakarta.validation.constraints.NotBlank

class CreateCommunityRequest{
    @NotBlank(message = "Please enter title")
    val title: String? = null
    @NotBlank(message = "Please enter description")
    val description: String? = null
}
