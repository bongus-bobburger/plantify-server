package com.bongus.plantify.domain.member.adapter.`in`.dto.req

import com.fasterxml.jackson.annotation.JsonProperty

class EditMemberRequest (

    @JsonProperty("name") val name: String,

)