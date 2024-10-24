package com.Backend.BackendCementerio.trabajadores.asistencia.services;

import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import com.Backend.BackendCementerio.trabajadores.persistencia.repository.TrabajadorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRespository trabajadorRespository;

    public Optional<Trabajador> findByCodigo(Long codigo) {
        return trabajadorRespository.findByCodigo(codigo);
    }
}

