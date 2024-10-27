package com.Backend.BackendCementerio.usuario.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Backend.BackendCementerio.usuario.security.JWT.JwtFiltro;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    private JwtFiltro jwtFiltro;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authRequest -> authRequest
                .requestMatchers("/registro", "/loggin", "/api/reservatumba", "/api/reservamisa","/h2-console", "/asistencia/**").permitAll() // Permitir acceso
                .requestMatchers("/test/get", "/test/post").permitAll() //pruebas
                    .requestMatchers("/asistencia/crear").permitAll()
                .anyRequest().authenticated() // Cualquier otro endpoint necesita autenticación
            )
            .sessionManagement(sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)  
            .addFilterBefore(jwtFiltro, UsernamePasswordAuthenticationFilter.class)
            .build();
    }



}

