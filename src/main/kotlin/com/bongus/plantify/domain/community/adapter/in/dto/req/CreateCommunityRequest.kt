package com.bongus.plantify.domain.community.adapter.`in`.dto.req

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank

class CreateCommunityRequest(
    @NotBlank(message = "Please enter title")
    @JsonProperty("title")
    val title: String,
    @JsonProperty("imageUrl")
    val imageUrl: String,
    @NotBlank(message = "Please enter description")
    @JsonProperty("description")
    val description: String
)