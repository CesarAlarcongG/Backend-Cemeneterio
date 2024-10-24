package com.Backend.BackendCementerio.trabajadores.persistencia.repository;

import com.Backend.BackendCementerio.trabajadores.persistencia.model.RegistroHorario;
import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroHorarioRepository extends JpaRepository<RegistroHorario, Long> {

    // Método para encontrar un registro por trabajador y fecha
    Optional<RegistroHorario> findByTrabajadorAndFecha(Trabajador trabajador, String fecha);
}

