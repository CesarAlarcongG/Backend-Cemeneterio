package com.Backend.BackendCementerio.trabajadores.asistencia.services;

import com.Backend.BackendCementerio.trabajadores.persistencia.model.RegistroHorario;
import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import com.Backend.BackendCementerio.trabajadores.persistencia.repository.RegistroHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroHorarioService {

    @Autowired
    private RegistroHorarioRepository registroHorarioRepository;

    // Buscar registro de asistencia por trabajador y fecha
    public Optional<RegistroHorario> findByTrabajadorAndFecha(Trabajador trabajador, String fecha) {
        return registroHorarioRepository.findByTrabajadorAndFecha(trabajador, fecha);
    }

    // Guardar nuevo registro de asistencia
    public void guardarRegistroHorario(RegistroHorario registroHorario) {
        registroHorarioRepository.save(registroHorario);
    }

    // Actualizar registro existente
    public void actualizarRegistroHorario(RegistroHorario registroHorario) {
        registroHorarioRepository.save(registroHorario);
    }
}
