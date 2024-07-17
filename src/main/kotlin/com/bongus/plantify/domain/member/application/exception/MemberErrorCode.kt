package com.bongus.plantify.domain.member.application.exception

import com.bongus.plantify.global.auth.exception.CustomErrorCode
import org.springframework.http.HttpStatus

enum class MemberErrorCode (
    override val status: HttpStatus,
    override val message: String,
) : CustomErrorCode {

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND,  "멤버를 찾을 수 없습니다"),
    MEMBER_ALREADY_EXIST(HttpStatus.CONFLICT,  "멤버가 이미 존재합니다"),
    MEMBER_NOT_SUFFICIENT(HttpStatus.PARTIAL_CONTENT, "멤버의 정보가 부족합니다"),
    MEMBER_ALREADY_SUFFICIENT(HttpStatus.ALREADY_REPORTED,  "가입이 완료된 계정입니다"),

}