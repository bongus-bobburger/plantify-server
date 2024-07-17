package com.bongus.plantify.domain.openai

import com.bongus.plantify.domain.openai.dto.request.ChatGPTRequest
import com.bongus.plantify.domain.openai.dto.response.ChatGPTResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.HttpEntity
import org.springframework.http.MediaType
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/bot")
class CustomBotController(private val template: RestTemplate) {
    @Value("\${openai.model}")
    private lateinit var model: String

    @Value("\${openai.api.url}")
    private lateinit var apiURL: String

    @PostMapping("/chat")
    fun chat(
        @RequestParam(name = "image") image: MultipartFile
    ): String {
        val prompt: String = "이미지 설명해줘"
        val request = ChatGPTRequest(model = model, prompt = prompt)

        // Prepare the request entity with multipart form data
        val headers = org.springframework.http.HttpHeaders()
        headers.contentType = MediaType.MULTIPART_FORM_DATA

        val body = LinkedMultiValueMap<String, Any>()
        body.add("prompt", prompt)
        body.add("model", model)
        body.add("image", MultipartFileResource(image))

        val requestEntity = HttpEntity(body, headers)

        val chatGPTResponse = template.postForObject(
            apiURL, requestEntity,
            ChatGPTResponse::class.java
        )

        return chatGPTResponse!!.choices?.get(0)?.message?.content!!
    }
}

class MultipartFileResource(private val file: MultipartFile) : ByteArrayResource(file.bytes) {
    override fun getFilename(): String? {
        return file.originalFilename
    }

    override fun getDescription(): String {
        return "Multipart file resource [filename=${getFilename()}]"
    }
}