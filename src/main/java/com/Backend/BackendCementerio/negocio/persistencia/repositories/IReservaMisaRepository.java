package com.Backend.BackendCementerio.negocio.persistencia.repositories;

import com.Backend.BackendCementerio.negocio.persistencia.models.ReservaMisa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaMisaRepository extends JpaRepository<ReservaMisa, Long> {
   
}
