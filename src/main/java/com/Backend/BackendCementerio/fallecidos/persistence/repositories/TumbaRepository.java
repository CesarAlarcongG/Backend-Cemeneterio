package com.Backend.BackendCementerio.fallecidos.persistence.repositories;

import com.Backend.BackendCementerio.fallecidos.persistence.models.Tumba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TumbaRepository extends JpaRepository<Tumba, Long> {
}
