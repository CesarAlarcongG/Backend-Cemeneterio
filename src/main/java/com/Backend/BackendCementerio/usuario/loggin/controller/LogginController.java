package com.Backend.BackendCementerio.usuario.loggin.controller;

import com.Backend.BackendCementerio.usuario.General.ResponseController;
import com.Backend.BackendCementerio.usuario.loggin.dto.CredencialesUsuarioDTO;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.BackendCementerio.usuario.loggin.service.LogginService;
import com.Backend.BackendCementerio.config.security.jwt.Token.Token;

import java.util.Optional;


@RestController
@RequestMapping("/loggin")
public class LogginController {
    @Autowired
    private LogginService logginService;
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @PostMapping("/usuario")
    public ResponseEntity<?> loggin(@RequestBody CredencialesUsuarioDTO usuarioDTO) {
        ResponseController response = new ResponseController();
        try{
            Token token = logginService.loggin(usuarioDTO);
            Usuario usuario = usuarioRepository.findByCorreo(usuarioDTO.getCorreo()).get();
            if (usuario != null){
                response.setToken(token);
                response.setUsuario(usuario);
            }else{
                System.out.println("No se encontro el usuario");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            System.out.println("Hay un problema aquí ----------------------------------"+e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(response);
    }

}
