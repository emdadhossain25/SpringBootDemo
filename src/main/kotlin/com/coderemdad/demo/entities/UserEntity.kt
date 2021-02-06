package com.coderemdad.demo.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class UserEntity(
    @Id
    @GeneratedValue
    var userId: Long,
    var userName: String,
    var email: String,
    var passwordHash: String,
    var createdAt: String,
    var isActive: Int

)