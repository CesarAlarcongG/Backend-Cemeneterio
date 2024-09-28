package com.Backend.BackendCementerio.usuario.registro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.registro.service.interfaces.RegistroService;

@RestController
@RequestMapping("registro")
public class RegistroController {
    @Autowired
    private RegistroService registroService;

    @PostMapping
    public ResponseEntity<String> crearCuenta(@RequestBody Usuario usuario){

        if (registroService.verificarExistenciaDeCuenta(usuario.getCorreo())) {
            //409
            return new ResponseEntity<>("El correo ya fue registrado en otra cuenta", HttpStatus.CONFLICT);
        }

        registroService.resgistrarCuenta(usuario);
        //201
        return new ResponseEntity<>("El correo ya fue registrado en otra cuenta", HttpStatus.CREATED);
    }

}
