package com.bongus.plantify.domain.member.adapter.`in`.dto.req

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email

data class RegisterMemberRequest (

    @JsonProperty("name") val name: String,
    @JsonProperty("email") @Email val email: String,
    @JsonProperty("password") val password: String

)