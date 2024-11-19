package com.Backend.BackendCementerio.usuario.pruebas;

import com.Backend.BackendCementerio.test.Prueba;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/123455")
public class Controllador {
    @Autowired
    private TestRepository testRepository;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return testRepository.findAll();
    }

    @PostMapping("/json")
    public Prueba pruebaTokenYJson(@RequestBody Prueba prueba){
        return prueba;
    }
}
