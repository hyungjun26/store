package com.study.store.config;

import com.study.store.component.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
