package com.Backend.BackendCementerio.negocio.persistencia.repositories;

import com.Backend.BackendCementerio.negocio.persistencia.models.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoServicioRepository extends JpaRepository<TipoServicio, Long> {
    Optional<TipoServicio> findByTipoServicio(String tipoServicio);

}
