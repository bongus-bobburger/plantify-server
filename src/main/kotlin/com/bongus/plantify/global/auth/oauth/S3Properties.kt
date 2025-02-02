package com.bongus.plantify.global.auth.oauth

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class S3Properties (
    @Value("\${cloud.aws.credentials.accessKey}") val accessKey: String,
    @Value("\${cloud.aws.credentials.secretKey}") val secretKey: String,
    @Value("\${cloud.aws.s3.bucket}") val bucket: String
)