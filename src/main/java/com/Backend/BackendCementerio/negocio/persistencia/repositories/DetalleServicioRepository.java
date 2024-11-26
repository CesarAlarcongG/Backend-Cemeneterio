package com.Backend.BackendCementerio.negocio.persistencia.repositories;

import com.Backend.BackendCementerio.negocio.persistencia.models.DetalleServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleServicioRepository extends JpaRepository<DetalleServicio, Long> {
    DetalleServicio save(DetalleServicio detalleServicio);
    boolean existsByServiciosAndFechaReservaAndHoraInicio(Servicios servicios, String fechaReserva, String horaInicio);
    List<DetalleServicio> findAllByFechaReserva(String fecha);
}
