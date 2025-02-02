package com.bongus.plantify.global.infra.aws.s3.exception

import com.bongus.plantify.global.auth.exception.CustomErrorCode
import org.springframework.http.HttpStatus

enum class S3Exception (
    override val status: HttpStatus,
    override val message: String,
): CustomErrorCode {

    FILE_UPLOAD_FAIL(HttpStatus.EXPECTATION_FAILED, "파일 업로드에 실패하였습니다."),
    FILE_EMPTY(HttpStatus.BAD_REQUEST, "빈 파일입니다.")

}