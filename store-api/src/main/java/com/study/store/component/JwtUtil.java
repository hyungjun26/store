package com.study.store.component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;


public class JwtUtil {
    public String createToken(long userId, String userName){
        Key key = Keys.hmacShaKeyFor("hellohellohellohellohellohello12".getBytes());
        String token = Jwts.builder()
                .claim("userId", userId)
                .claim("userName", userName)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return token;
    }
}
