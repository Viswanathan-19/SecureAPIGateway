package com.viswa.user.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "Users from User Service";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id) {
        return "User ID: " + id;
    }
}