package com.Backend.BackendCementerio.usuario.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicacitionConfig {

    @Autowired
    private IUsuarioRepository usuarioRepository;


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception{
        try {
            return config.getAuthenticationManager();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el AuthenticationManager", e);
        }
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> usuarioRepository.findByCorreo(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }

}
