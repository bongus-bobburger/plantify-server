package com.bongus.plantify.global.auth.jwt.exception

import com.bongus.plantify.global.auth.exception.CustomErrorCode
import org.springframework.http.HttpStatus

enum class JwtErrorCode (
    override val status: HttpStatus,
    override val message: String,
): CustomErrorCode {

    JWT_TOKEN_EXPIRED(HttpStatus.FORBIDDEN,  "토큰이 만료되었어요"),
    JWT_TOKEN_SIGNATURE_ERROR(HttpStatus.UNAUTHORIZED ,"토큰의 서명이 일치하지 않아요"),
    JWT_TOKEN_ERROR(HttpStatus.UNAUTHORIZED, "토큰이 구조가 이상하거나 데이터가 일치하지 않아요"),
    JWT_TOKEN_UNSUPPORTED_ERROR(HttpStatus.UNAUTHORIZED,  "지원하지않는 토큰이에요"),
    JWT_TOKEN_ILL_EXCEPTION(HttpStatus.UNAUTHORIZED,  "JWT 처리 과정에서 오류가 발생했어요"),
    JWT_UNKNOWN_EXCEPTION(HttpStatus.UNAUTHORIZED,  "JWT 처리과정에서 알수없는 오류가 발생했어요"),
    JWT_MEMBER_NOT_MATCH(HttpStatus.UNAUTHORIZED,  "비밀번호가 일치하지 않아요"),
    JWT_EMPTY_EXCEPTION(HttpStatus.FORBIDDEN,  "토큰을 넣어주세요."),

}