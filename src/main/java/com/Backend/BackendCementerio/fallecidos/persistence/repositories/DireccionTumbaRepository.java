package com.Backend.BackendCementerio.fallecidos.persistence.repositories;

import com.Backend.BackendCementerio.fallecidos.persistence.models.DireccionTumba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionTumbaRepository extends JpaRepository<DireccionTumba, Long> {
}
