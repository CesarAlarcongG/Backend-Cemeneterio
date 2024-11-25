package com.Backend.BackendCementerio.test;

import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class ControllerTest {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @GetMapping("/get")
    public String getPublico() {
        return "Este es un endpoint público";
    }

    @GetMapping("/getP")
    public String getPrivado() {
        return "Este es un endpoint privado";
    }

    @PostMapping("/post")
    public String postPublico() {
        return "Este es un endpoint público";
    }

    @PostMapping("/postP")
    public String postPrivado() {
        return "Este es un endpoint privado";
    }

    @PostMapping("/json")
    public ResponseEntity<Prueba> pruebaTokenYJson(@RequestBody Prueba prueba){
        return ResponseEntity.ok( prueba);
    }
    @GetMapping("/usuarios")
    public List<Usuario> traerTodosLosUsuarios(){
        return usuarioRepository.findAll();
    }
}

