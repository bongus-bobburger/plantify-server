package com.bongus.plantify.domain.price.adaptor.out.repository

import com.bongus.plantify.domain.price.adaptor.out.entity.PriceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PriceRepository: JpaRepository<PriceEntity, Long> {
}