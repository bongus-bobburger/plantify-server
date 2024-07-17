package com.bongus.plantify.domain.community.adapter.out.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

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
    var userId : Long = 0,

    @CreatedDate
    var createdDate: LocalDateTime? = null,

    @LastModifiedDate
    var lastModifiedDate: LocalDateTime? = null

)