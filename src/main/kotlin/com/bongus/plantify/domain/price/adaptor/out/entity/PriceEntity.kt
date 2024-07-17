package com.bongus.plantify.domain.price.adaptor.out.entity

import jakarta.persistence.*

@Entity
data class PriceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    var price: String,

    var imageUrl: String? = null
)
