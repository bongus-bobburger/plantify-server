package com.bongus.plantify.global.auth.exception

import com.bongus.plantify.global.response.BaseResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun handleCustomException(customException: CustomException): ResponseEntity<Any> {
        val response = BaseResponse<Unit>(
            status = customException.customErrorCode.status.value(),
            success = false,
            message = customException.customErrorCode.message,
        )

        return ResponseEntity(response, customException.customErrorCode.status)
    }

}