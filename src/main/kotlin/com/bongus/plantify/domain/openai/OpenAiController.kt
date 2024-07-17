package com.bongus.plantify.domain.openai

import org.apache.http.HttpEntity
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.nio.charset.StandardCharsets

@RestController
@RequestMapping("/api")
class ImageAnalysisController{
    @Value("\${openai.api.key}")
    private lateinit var apiKey: String

    @PostMapping("/analyze")
    fun analyzeImage(
        @RequestParam("image") image: MultipartFile,
    ): String {

        val openAiUrl = "https://api.openai.com/v1/chat/completions"

        val httpClient: CloseableHttpClient = HttpClients.createDefault()

        try {
            // Prepare multipart/form-data request
            val builder = MultipartEntityBuilder.create()
            builder.addBinaryBody("image", image.bytes, ContentType.MULTIPART_FORM_DATA, image.originalFilename)
            builder.addTextBody("prompt", "이미지를 설명해줘", ContentType.create("text/plain", StandardCharsets.UTF_8))

            val entity: HttpEntity = builder.build()
            val httpPost = HttpPost(openAiUrl)
            httpPost.addHeader("Authorization", "Bearer $apiKey")
            httpPost.entity = entity

            val response: CloseableHttpResponse = httpClient.execute(httpPost)
            val responseBody: String = EntityUtils.toString(response.entity)

            return responseBody
        } finally {
            httpClient.close()
        }
    }
}