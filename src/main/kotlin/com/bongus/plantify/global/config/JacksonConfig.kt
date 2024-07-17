package com.bongus.plantify.global.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class JacksonConfig : WebMvcConfigurer {
    @Bean
    fun javaTimeModule(): JavaTimeModule {
        return JavaTimeModule()
    }
    @Bean
    fun customObjectMapper(builder: Jackson2ObjectMapperBuilder): ObjectMapper {
        val objectMapper = builder.build<ObjectMapper>()
        objectMapper.registerModule(JavaTimeModule())
        return objectMapper
    }
}