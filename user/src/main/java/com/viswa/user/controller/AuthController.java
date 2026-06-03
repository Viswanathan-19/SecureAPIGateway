package com.viswa.user.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey";

    @GetMapping("/token")
    public String generateToken() {
        Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

        return Jwts.builder()
                .setSubject("viswa")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .signWith(key)
                .compact();
    }
}