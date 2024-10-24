package com.Backend.BackendCementerio.trabajadores.persistencia.repository;


import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrabajadorRespository extends JpaRepository<Trabajador, Long> {
 Optional<Trabajador> findByCodigo(Long codigo);

 boolean findByCodigoAndFecha(Long codigo, String fecha);
}
