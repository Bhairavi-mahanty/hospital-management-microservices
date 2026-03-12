package com.gateWay.controller;

import com.gateWay.dto.LoginRequest;
import com.gateWay.dto.TokenResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${jwt." +
            "secret-key}")
    private String secretKey;

    @PostMapping("/generate-token")
    public TokenResponse generateToken(@RequestBody LoginRequest request) {
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
        
        String token = Jwts.builder()
                .setSubject(request.getUsername())
                .claim("role", request.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
                .signWith(key)
                .compact();

        return new TokenResponse(token, request.getUsername(), request.getRole());
    }
}