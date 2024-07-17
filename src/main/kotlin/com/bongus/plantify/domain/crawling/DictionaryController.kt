package com.bongus.plantify.domain.crawling

import com.bongus.plantify.domain.openai.dto.request.GPTRequest
import com.bongus.plantify.domain.openai.dto.response.ChatGPTResponse
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/dictionaries")
class DictionaryController (
    private val template: RestTemplate,
    private val webCrawlerService: WebCrawlerService,
){
    @Value("\${openai.model}")
    private lateinit var model: String

    @Value("\${openai.api.url}")
    private lateinit var apiURL: String

    @GetMapping
    fun crawler(@RequestParam keyword: String){
        webCrawlerService.crawlWebsite(keyword);
    }

    @GetMapping("/gpt")
    fun chat(@RequestParam(name = "prompt") prompt: String?
        ): BaseResponse<String> {
        if (prompt == null) {
            throw IllegalArgumentException("Prompt must not be null")
        }

        val request = GPTRequest(model = model, prompt = prompt)
        val chatGPTResponse = template.postForObject(
            apiURL, request,
            ChatGPTResponse::class.java
        )
        val keyWord: String = chatGPTResponse?.choices?.get(0)?.message?.content
            ?: throw IllegalStateException("No response from AI")
        return BaseResponse(
            message = "답변이 도착했습니다",
            data = keyWord
        )
    }

}