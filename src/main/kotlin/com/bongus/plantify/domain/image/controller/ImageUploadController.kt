package com.bongus.plantify.domain.image.controller

import com.bongus.plantify.global.infra.aws.s3.service.S3
import com.bongus.plantify.global.infra.aws.s3.type.FileType
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/image")
class ImageUploadController (
    private val s3: S3
){
    @PostMapping("/upload")
    fun uploadImage(image: MultipartFile): BaseResponse<String> {
        return BaseResponse(
            message = "등록 완료",
            data = s3.uploadMultipleFile(image, FileType.IMG)
        )
    }
}