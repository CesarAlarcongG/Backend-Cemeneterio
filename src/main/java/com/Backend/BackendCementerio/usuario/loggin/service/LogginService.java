package com.Backend.BackendCementerio.usuario.loggin.service;

import com.Backend.BackendCementerio.usuario.loggin.dto.CredencialesUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Backend.BackendCementerio.config.security.jwt.Token.Token;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
import com.Backend.BackendCementerio.config.security.jwt.JwtService;


@Service
public class LogginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUsuarioRepository uRepository;
    @Autowired
    private JwtService jwtService;



    public Token loggin(CredencialesUsuarioDTO credencialesDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credencialesDTO.getCorreo(), credencialesDTO.getContraseña()));
        UserDetails user = uRepository.findByCorreo(credencialesDTO.getCorreo()).orElseThrow();
        String stringToken = jwtService.getToken(user);
        Token token = new Token (stringToken);
        return token;
    }




}
