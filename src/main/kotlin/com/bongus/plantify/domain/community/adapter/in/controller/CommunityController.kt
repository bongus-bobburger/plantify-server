package com.bongus.plantify.domain.community.adapter.`in`.controller

import com.bongus.plantify.domain.community.adapter.`in`.dto.req.CreateCommunityRequest
import com.bongus.plantify.domain.community.adapter.out.entity.CommunityEntity
import com.bongus.plantify.domain.community.application.service.CommunityService
import com.bongus.plantify.global.infra.aws.s3.service.S3
import com.bongus.plantify.global.infra.aws.s3.type.FileType
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/community")
class CommunityController (
    private val communityService: CommunityService,
    private val s3: S3
){
    @GetMapping
    fun getAllCommunities(): BaseResponse<List<CommunityEntity>> {
        return communityService.findAll()
    }

    @PostMapping
    fun registerCommunity(request: CreateCommunityRequest): BaseResponse<Unit> {
        return communityService.register(request)
    }

    @PostMapping("/upload")
    fun uploadImage(image: MultipartFile): BaseResponse<String> {
        return BaseResponse(
            message = "등록 완료",
            data = s3.uploadMultipleFile(image, FileType.IMG)
        )
    }

}