package com.Backend.BackendCementerio.trabajadores.persistencia.repository;

import com.Backend.BackendCementerio.trabajadores.persistencia.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
