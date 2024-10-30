package com.Backend.BackendCementerio.trabajadores.persistencia.repository;


import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrabajadorRespository extends JpaRepository<Trabajador, Long> {

 Optional<Trabajador> findByDni(Long dni);
}
