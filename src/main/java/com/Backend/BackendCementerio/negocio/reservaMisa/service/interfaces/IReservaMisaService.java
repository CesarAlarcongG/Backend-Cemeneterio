package com.Backend.BackendCementerio.negocio.reservaMisa.service.interfaces;

import com.Backend.BackendCementerio.negocio.persistencia.models.ReservaMisa;
import java.util.List;

public interface IReservaMisaService {
    List<ReservaMisa> findAll();
    ReservaMisa findById(Long id);
    ReservaMisa save(ReservaMisa reservaMisa);
    void delete(Long id);
}

