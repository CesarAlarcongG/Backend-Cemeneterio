package com.Backend.BackendCementerio.trabajadores.administrar.controller;

import com.Backend.BackendCementerio.trabajadores.administrar.dto.TrabajadorDTO;

import com.Backend.BackendCementerio.trabajadores.administrar.service.AdministrarService;
import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/trabajador")
public class AdministrarController {

    @Autowired
    private AdministrarService administrarService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearTrabajador(@RequestBody TrabajadorDTO trabajadorDTO) {
        // Verificar si ya existe un trabajador con el mismo DNI
        Optional<Trabajador> trabajadorExistente = administrarService.obtenerTrabajadorPorDni(trabajadorDTO.getDni());

        if (trabajadorExistente.isPresent()) {
            return new ResponseEntity<>("Ya existe un trabajador con el DNI proporcionado", HttpStatus.CONFLICT);
        }

        // Si no existe, proceder a crear el trabajador
        boolean creado = administrarService.crearTrabajador(trabajadorDTO);

        return creado ?
                new ResponseEntity<>("Trabajador creado", HttpStatus.CREATED) :
                new ResponseEntity<>("No se pudo crear al trabajador", HttpStatus.CONFLICT);
    }


    @GetMapping("traer/{dni}")
    public ResponseEntity<Trabajador> obtenerTrabajadorPorDni(@PathVariable Long dni) {
        Optional<Trabajador> trabajador = administrarService.obtenerTrabajadorPorDni(dni);
        return trabajador.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/todos")
    public ResponseEntity<Iterable<Trabajador>> obtenerTodosLosTrabajadores() {
        Iterable<Trabajador> trabajadores = administrarService.obtenerTodosLosTrabajadores();
        return new ResponseEntity<>(trabajadores, HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarTrabajador(@RequestBody TrabajadorDTO trabajadorDTO) {
        return administrarService.actualizarTrabajador(trabajadorDTO) ?
                new ResponseEntity<>("Trabajador actualizado", HttpStatus.OK) :
                new ResponseEntity<>("No se pudo actualizar al trabajador", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{dni}")
    public ResponseEntity<String> eliminarTrabajador(@PathVariable Long dni) {
        return administrarService.eliminarTrabajador(dni) ?
                new ResponseEntity<>("Trabajador eliminado", HttpStatus.OK) :
                new ResponseEntity<>("No se pudo eliminar al trabajador", HttpStatus.NOT_FOUND);
    }


}
