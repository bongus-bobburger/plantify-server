package com.bongus.plantify.domain.openai

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
class CustomBotController (private val template: RestTemplate){
    @Value("\${openai.model}")
    private lateinit var model: String

    @Value("\${openai.api.url}")
    private lateinit var apiURL: String

    @GetMapping("/chat")
    fun chat(@RequestParam(name = "prompt") prompt: String?): String {
        val request = ChatGPTRequest(model = model, prompt = prompt!!)
        val chatGPTResponse = template.postForObject(
            apiURL, request,
            ChatGPTResponse::class.java
        )
        return chatGPTResponse!!.choices?.get(0)?.message?.content!!
    }
}