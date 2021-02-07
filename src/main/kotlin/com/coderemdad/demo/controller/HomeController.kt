package com.coderemdad.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HomeController {

    @GetMapping("/home")
    fun home(): String {
        return ("<h1>Welcome Home</h1>")
    }

    @GetMapping("/admin")
    fun admin(): String {
        return ("<h1>Welcome Admin</h1>")
    }

    @GetMapping("")
    fun general(): String {
        return ("<h1>Welcome</h1>")
    }
}