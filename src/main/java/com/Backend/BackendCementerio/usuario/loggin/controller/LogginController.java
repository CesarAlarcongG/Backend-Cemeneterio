package com.Backend.BackendCementerio.usuario.loggin.controller;

import com.Backend.BackendCementerio.usuario.loggin.dto.CredencialesUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.BackendCementerio.usuario.loggin.service.LogginService;
import com.Backend.BackendCementerio.usuario.persistence.model.Token;


@RestController
@RequestMapping("/loggin")
public class LogginController {
    @Autowired
    private LogginService logginService;

    @PostMapping("/usuario")
    public ResponseEntity<Token> loggin(@RequestBody CredencialesUsuarioDTO usuarioDTO) {
        return ResponseEntity.ok( logginService.loggin(usuarioDTO));
    }

}
