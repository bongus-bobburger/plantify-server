package com.bongus.plantify.domain.openai.dto.request

import com.bongus.plantify.domain.openai.dto.Message

data class ChatGPTRequest(val model: String, private val prompt: String, private val imageUrl: String) {
    val messages: MutableList<Message> = ArrayList<Message>()

    init {
        messages.add(Message("user", prompt))
    }

}