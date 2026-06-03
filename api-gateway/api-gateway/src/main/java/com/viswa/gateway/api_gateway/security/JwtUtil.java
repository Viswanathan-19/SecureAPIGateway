package com.viswa.gateway.api_gateway.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {

    private static final String SECRET = "mysecretkeymysecretkeymysecretkey"; // 32+ chars
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}