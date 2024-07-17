package com.bongus.plantify.domain.community.adapter.out.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*

@Entity
class CommunityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var title: String? = null

    @Column(nullable = false)
    var description: String? = null

    @Column(nullable = false)
    var userId : Long? = null

    @CreatedDate
    var createdDate: Date? = null

    @LastModifiedDate
    var modifiedDate: Date? = null

}