package com.coderemdad.demo.repository

import com.coderemdad.demo.entities.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Long> {

    fun findUserEntityByUserId(userId: Long): UserEntity



}