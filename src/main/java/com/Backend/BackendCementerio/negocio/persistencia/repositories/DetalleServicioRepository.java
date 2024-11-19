package com.Backend.BackendCementerio.negocio.persistencia.repositories;

import com.Backend.BackendCementerio.negocio.persistencia.models.DetalleServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetalleServicioRepository extends JpaRepository<DetalleServicio, Long> {
    DetalleServicio save(DetalleServicio detalleServicio);
}
