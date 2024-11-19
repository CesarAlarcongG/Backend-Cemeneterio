package com.Backend.BackendCementerio.negocio.persistencia.repositories;

import com.Backend.BackendCementerio.negocio.persistencia.models.EstadoServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.enums.EstadoServicioEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoServicioRepository extends JpaRepository<EstadoServicio, Long> {
    Optional<EstadoServicio> findByEstado(EstadoServicioEnum estadoServicioEnum);
}
