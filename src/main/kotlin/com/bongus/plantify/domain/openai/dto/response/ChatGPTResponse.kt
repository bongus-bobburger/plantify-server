package com.bongus.plantify.domain.openai.dto.response

import com.bongus.plantify.domain.openai.dto.Message

data class ChatGPTResponse (val choices: List<Choice>? = null){

    data class Choice( val index:Int = 0, val message: Message? = null)

}
