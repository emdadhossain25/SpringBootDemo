package com.coderemdad.demo.controller

import DeleteRequest
import com.coderemdad.demo.entities.UserEntity
import com.coderemdad.demo.repository.UserRepository
import org.springframework.web.bind.annotation.*
import java.security.MessageDigest

@RestController
@RequestMapping("api/")
class UserController(val repo: UserRepository) {
    //create
    @PostMapping("/insertuser")
    fun addUsers(@RequestBody userRequest: UserEntity) {
        userRequest.passwordHash = userRequest.passwordHash.sha256()
        repo.save(userRequest)
    }

    //read
    @GetMapping("/getuser")
    fun getUsers() = repo.findAll().toList()


//    read

    @GetMapping("/getUser/{userId}")
    fun findUserById(@PathVariable("userId") userId: Long): UserEntity {
        var findUserEntityByUserId = repo.findUserEntityByUserId(userId)
        return findUserEntityByUserId
    }


    @PostMapping("/deleteuser")
    fun deleteUser(@RequestBody deleteRequest: DeleteRequest) {
        repo.deleteById(deleteRequest.userId)
    }

    @PostMapping("/updateUser")
    fun updateUser(@RequestBody updateRequest: UserEntity): UserEntity {
        var updated = repo.save(updateRequest)
        return updated
    }

    fun String.sha256(): String {
        return hashString(this, "SHA-256")
    }

    private fun hashString(input: String, algorithm: String): String {
        return MessageDigest
            .getInstance(algorithm)
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
    }
}