package com.Backend.BackendCementerio.trabajadores.asistencia.controller;

import com.Backend.BackendCementerio.trabajadores.asistencia.dto.CredencialesDTO;
import com.Backend.BackendCementerio.trabajadores.asistencia.services.RegistroHorarioService;
import com.Backend.BackendCementerio.trabajadores.asistencia.services.TrabajadorService;
import com.Backend.BackendCementerio.trabajadores.persistencia.model.RegistroHorario;
import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asistencia")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @Autowired
    private RegistroHorarioService registroHorarioService;

    @PostMapping
    public ResponseEntity<String> registrarAsistencia(@RequestBody CredencialesDTO credenciales) {

        Optional<Trabajador> trabajadorOpt = trabajadorService.findByDni(credenciales.getDni());

        if (!trabajadorOpt.isPresent()) {
            return new ResponseEntity<>("No existe el trabajador", HttpStatus.NOT_FOUND);
        }

        Trabajador trabajador = trabajadorOpt.get();

        Optional<RegistroHorario> registroOpt = registroHorarioService.findByTrabajadorAndFecha(trabajador, credenciales.getFecha());

        if (registroOpt.isPresent()) {
            RegistroHorario registro = registroOpt.get();

            // sssi ya tiene hora de ingreso pero qno tiene hora de salida actualizar la hora de salida
            if (registro.getHoraSalida() == null) {
                registro.setHoraSalida(credenciales.getHora());
                registroHorarioService.actualizarRegistroHorario(registro);
                return new ResponseEntity<>("Hora de salida registrada correctamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Ya se registró la hora de salida para esta fecha", HttpStatus.BAD_REQUEST);
            }

        } else {


            // si no tiene registro de asidtencia registrar la hora de ingreso
            RegistroHorario nuevoRegistro = new RegistroHorario();
            nuevoRegistro.setFecha(credenciales.getFecha());
            nuevoRegistro.setHoraIngreso(credenciales.getHora());
            nuevoRegistro.setTrabajador(trabajador);
            registroHorarioService.guardarRegistroHorario(nuevoRegistro);
            return new ResponseEntity<>("Hora de ingreso registrada correctamente", HttpStatus.CREATED);
        }

    }


    @GetMapping("/empleados")
    public List<Trabajador> obtenerEmpleados(){
        return trabajadorService.obtenerTrabajadores();
    }

}


