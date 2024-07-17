package com.bongus.plantify.domain.community.application.exception

import com.bongus.plantify.global.auth.exception.CustomErrorCode
import org.springframework.http.HttpStatus

enum class CommunityErrorCode (
    override val status: HttpStatus,
    override val message: String
) : CustomErrorCode {

}