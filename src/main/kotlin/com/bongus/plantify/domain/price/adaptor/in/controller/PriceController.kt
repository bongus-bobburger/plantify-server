package com.bongus.plantify.domain.price.adaptor.`in`.controller

import com.bongus.plantify.domain.price.adaptor.`in`.dto.PriceRequest
import com.bongus.plantify.domain.price.adaptor.out.entity.PriceEntity
import com.bongus.plantify.domain.price.application.service.PriceService
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/price")
class PriceController (
    private val priceService: PriceService
){
    @GetMapping
    fun getPrices():BaseResponse<List<PriceEntity>>{
        return priceService.findAll()
    }

    @GetMapping("/find")
    fun findPrices(@RequestParam title: String): BaseResponse<List<PriceEntity>> {
        return priceService.findByTitle(title)
    }

    @PostMapping
    fun register(@RequestBody request: PriceRequest):BaseResponse<Unit> {
        return priceService.register(request)
    }

}