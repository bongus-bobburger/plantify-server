package com.bongus.plantify.domain.price.application.service

import com.bongus.plantify.domain.price.adaptor.`in`.dto.PriceRequest
import com.bongus.plantify.domain.price.adaptor.out.entity.PriceEntity
import com.bongus.plantify.domain.price.adaptor.out.mapper.PriceMapper
import com.bongus.plantify.domain.price.adaptor.out.repository.PriceRepository
import com.bongus.plantify.domain.price.application.model.Price
import com.bongus.plantify.global.auth.jwt.JwtUtils
import com.bongus.plantify.global.response.BaseResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PriceService (
    private val priceRepository: PriceRepository,
    private val priceMapper: PriceMapper,
    private val jwtUtils: JwtUtils
) {
    @Transactional
    fun register(request:PriceRequest) : BaseResponse<Unit>{
        priceRepository.save(
            priceMapper.toEntity(
                Price(
                    request,jwtUtils.getMember().name.value
                )
            )
        )
        return BaseResponse(
            message = "제품 등록 성공"
        )
    }

    @Transactional(readOnly = true)
    fun findByTitle(title: String): BaseResponse<List<PriceEntity>> {
        return BaseResponse(
            message = "조회 성공",
            data = priceRepository.findByNameContainingIgnoreCase(title)
        )
    }

    @Transactional(readOnly = true)
    fun findAll(): BaseResponse<List<PriceEntity>> {
        return BaseResponse(
            message = "조회 성공",
            data = priceRepository.findAll()
        )
    }

}