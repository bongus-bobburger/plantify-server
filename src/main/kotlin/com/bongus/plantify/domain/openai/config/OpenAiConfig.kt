package com.bongus.plantify.domain.openai.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.web.client.RestTemplate

@Configuration
class OpenAiConfig {
    @Value("\${openai.api.key}")
    private val openAiKey: String? = null
    @Bean
    fun template(): RestTemplate {
        val restTemplate = RestTemplate()
        restTemplate.interceptors.add(ClientHttpRequestInterceptor { request: HttpRequest, body: ByteArray?, execution: ClientHttpRequestExecution ->
            request.headers.add("Authorization", "Bearer $openAiKey")
            execution.execute(request, body!!)
        })
        return restTemplate
    }
}