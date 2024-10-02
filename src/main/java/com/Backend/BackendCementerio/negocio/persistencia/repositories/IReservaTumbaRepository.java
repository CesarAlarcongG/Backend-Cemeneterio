package com.Backend.BackendCementerio.negocio.persistencia.repositories;

import com.Backend.BackendCementerio.negocio.persistencia.models.ReservaTumba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaTumbaRepository extends JpaRepository<ReservaTumba, Long> {
    
}
