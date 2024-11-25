package com.Backend.BackendCementerio.usuario.registro.controller;

import com.Backend.BackendCementerio.config.security.jwt.Token.Token;
import com.Backend.BackendCementerio.usuario.General.ResponseController;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
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
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> crearCuenta(@RequestBody UsuarioDto usuarioDto){
        ResponseController response = new ResponseController();

        if (!registroService.validarFormatoCorreo(usuarioDto.getCorreo())) {
            return new ResponseEntity<>("El formato del correo es inválido", HttpStatus.BAD_REQUEST);
        }

        if (registroService.verificarExistenciaDeCuenta(usuarioDto.getCorreo())) {
            return new ResponseEntity<>("El correo ya fue registrado en otra cuenta", HttpStatus.CONFLICT);
        } else {
            // Almacena el usuario y obtiene el token
            Token token = new Token(registroService.resgistrarCuenta(usuarioDto).getToken());
            Usuario usuario = usuarioRepository.findByCorreo(usuarioDto.getCorreo()).get();
            //Verificamos si el usuario existe
            if (usuario != null){
                response.setToken(token);
                response.setUsuario(usuario);
            }else{
                System.out.println("No se encontro el usuario");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

}
