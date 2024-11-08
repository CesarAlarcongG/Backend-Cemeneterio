package com.Backend.BackendCementerio.usuario.registro.controller;

import com.Backend.BackendCementerio.usuario.persistence.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.BackendCementerio.usuario.registro.dto.UsuarioDto;
import com.Backend.BackendCementerio.usuario.registro.service.interfaces.RegistroService;

@RestController
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private RegistroService registroService;

    @PostMapping
    public ResponseEntity<String> crearCuenta(@RequestBody UsuarioDto usuarioDto){

        if (!registroService.validarFormatoCorreo(usuarioDto.getCorreo())) {
            return new ResponseEntity<>("El formato del correo es inválido", HttpStatus.BAD_REQUEST);
        }

        if (registroService.verificarExistenciaDeCuenta(usuarioDto.getCorreo())) {
            return new ResponseEntity<>("El correo ya fue registrado en otra cuenta", HttpStatus.CONFLICT);
        } else {
            // Almacena el usuario y obtiene el token
            String token = registroService.resgistrarCuenta(usuarioDto).getToken();
            return new ResponseEntity<>("Registro exitoso.\nToken: " + token, HttpStatus.CREATED);
        }
    }

}
