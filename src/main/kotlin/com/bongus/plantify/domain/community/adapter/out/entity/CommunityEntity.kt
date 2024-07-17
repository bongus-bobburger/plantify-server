package com.bongus.plantify.domain.community.adapter.out.entity

import jakarta.persistence.*

@Entity
data class CommunityEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var title: String = "",

    @Column(nullable = false)
    var description: String = "",

    @Column
    var imageUrl: String = "",

    @Column(nullable = false)
    var userName : String = "",

)