package com.study.store.component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {
    @Test
    public void createToken(){
        Key key = Keys.hmacShaKeyFor("hellohellohellohellohellohello12".getBytes());
        String token = Jwts.builder()
                .claim("userId", "test01")
                .claim("userName", "testName")
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        System.out.println(token);
    }
}