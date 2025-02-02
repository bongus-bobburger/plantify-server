package com.bongus.plantify.global.infra.aws.s3.service

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.bongus.plantify.global.auth.exception.CustomException
import com.bongus.plantify.global.auth.oauth.S3Properties
import com.bongus.plantify.global.infra.aws.s3.exception.S3Exception
import com.bongus.plantify.global.infra.aws.s3.type.FileType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Configuration
@Service
class S3(
    private val s3Properties: S3Properties
) {
    @Bean
    fun amazonS3Client(): AmazonS3 {
        return AmazonS3ClientBuilder.standard()
            .withCredentials(
                AWSStaticCredentialsProvider(BasicAWSCredentials(s3Properties.accessKey, s3Properties.secretKey))
            )
            .withRegion(Regions.AP_NORTHEAST_2)
            .build()
    }

    fun uploadMultipleFile(
        @RequestPart file: MultipartFile,
        type: FileType
    ): String {

        if (file.isEmpty || file.equals("")) {
            throw CustomException(S3Exception.FILE_EMPTY)
        }

        val fileName = createFileName(type, file.originalFilename ?: file.name)

        val objectMetadata = ObjectMetadata().apply {
            this.contentType = file.contentType
            this.contentLength = file.size
        }

        try {
            val putObjectRequest = PutObjectRequest(
                s3Properties.bucket,
                fileName,
                file.inputStream,
                objectMetadata
            ).withCannedAcl(CannedAccessControlList.PublicRead)  // 퍼블릭 읽기 권한 설정

            amazonS3Client().putObject(putObjectRequest)
        } catch (e: Exception) {
            throw CustomException(S3Exception.FILE_UPLOAD_FAIL)
        }

        return amazonS3Client().getUrl(s3Properties.bucket, fileName).toString()
    }

    private fun createFileName(type: FileType, originalName: String): String {
        return type.name + "/" + UUID.randomUUID() + "-" + originalName
    }
}