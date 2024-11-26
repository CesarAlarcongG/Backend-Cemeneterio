package com.Backend.BackendCementerio.fallecidos.CRUD.controller;

import com.Backend.BackendCementerio.fallecidos.CRUD.dto.FallecidoDTO;
import com.Backend.BackendCementerio.fallecidos.CRUD.service.FallecidoService;
import com.Backend.BackendCementerio.fallecidos.persistence.models.Fallecido;

import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
@RequestMapping("/fallecidos")
public class FallecidoController {

    @Autowired
    private FallecidoService fallecidoService;

    @GetMapping("/lista")
    public List<Fallecido> traerFallecidosDeUsuario(@RequestParam String correo) {
        return fallecidoService.traerFallecidosDeUsuarios(correo);
    }


    @GetMapping("/{id}")
    public Optional<Fallecido> getFallecidoById(@PathVariable Long id) {
        return fallecidoService.getFallecidoById(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> createFallecido(@RequestBody FallecidoDTO fallecido) {

        return ResponseEntity.ok(fallecidoService.crearFallecido(fallecido));
    }

    @PutMapping("/{id}")
    public Fallecido updateFallecido(@PathVariable Long id, @RequestBody Fallecido fallecido) {
        return fallecidoService.updateFallecido(id, fallecido);
    }

    @DeleteMapping("/{id}")
    public void deleteFallecido(@PathVariable Long id) {
        fallecidoService.deleteFallecido(id);
    }
}
