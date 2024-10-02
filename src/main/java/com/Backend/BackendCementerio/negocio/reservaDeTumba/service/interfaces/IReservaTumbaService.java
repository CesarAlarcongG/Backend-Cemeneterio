package com.Backend.BackendCementerio.negocio.reservaDeTumba.service.interfaces;

import com.Backend.BackendCementerio.negocio.persistencia.models.ReservaTumba;
import java.util.List;

public interface IReservaTumbaService {
    List<ReservaTumba> findAll();
    ReservaTumba findById(Long id);
    ReservaTumba save(ReservaTumba reservaTumba);
    void delete(Long id);
}
