package com.bongus.plantify.domain.openai

import com.bongus.plantify.domain.crawling.WebCrawlerService
import com.bongus.plantify.domain.openai.dto.request.ChatGPTRequest
import com.bongus.plantify.domain.openai.dto.response.ChatGPTResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/bot")
class CustomBotController(
    private val template: RestTemplate,
    private val webCrawlerService: WebCrawlerService) {

    @Value("\${openai.model}")
    private lateinit var model: String

    @Value("\${openai.api.url}")
    private lateinit var apiURL: String

    @GetMapping("/chat")
    fun chat(
        @RequestParam(name = "imageUrl") imageUrl: String?
    ): String {
        if ( imageUrl == null) {
            throw IllegalArgumentException("Prompt and imageUrl must not be null")
        }

        val request = ChatGPTRequest(model = model, prompt = "내가 보낸 이미지는 과일이나 일반 식물 중 하나야, 어떤 식물 또는 과일인지만 말해줘. 설명빼고 단어만, .도 빼 문장부호도 다 빼고 단어만", imageUrl = imageUrl)
        val chatGPTResponse = template.postForObject(
            apiURL, request,
            ChatGPTResponse::class.java
        )
        val keyWord: String = chatGPTResponse?.choices?.get(0)?.message?.content
            ?: throw IllegalStateException("No response from AI")

        return webCrawlerService.crawlWebsite(keyWord)
    }
}