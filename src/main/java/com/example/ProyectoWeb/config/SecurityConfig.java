package com.example.ProyectoWeb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF para usar Postman sin problemas
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite TODO sin autenticación
                )
                .headers(headers -> headers.frameOptions().disable()); // Para acceder a H2 Console si la usas

        return http.build();
    }
}