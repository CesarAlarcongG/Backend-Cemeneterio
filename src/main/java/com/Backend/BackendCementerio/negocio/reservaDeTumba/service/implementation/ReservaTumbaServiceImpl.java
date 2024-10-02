package com.Backend.BackendCementerio.negocio.reservaDeTumba.service.implementation;

import com.Backend.BackendCementerio.negocio.persistencia.models.ReservaTumba;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.IReservaTumbaRepository;
import com.Backend.BackendCementerio.negocio.reservaDeTumba.service.interfaces.IReservaTumbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaTumbaServiceImpl implements IReservaTumbaService {

    @Autowired
    private IReservaTumbaRepository reservaTumbaRepository;

    @Override
    public List<ReservaTumba> findAll() {
        return reservaTumbaRepository.findAll();
    }

    @Override
    public ReservaTumba findById(Long id) {
        return reservaTumbaRepository.findById(id).orElse(null);
    }

    @Override
    public ReservaTumba save(ReservaTumba reservaTumba) {
        return reservaTumbaRepository.save(reservaTumba);
    }

    @Override
    public void delete(Long id) {
        reservaTumbaRepository.deleteById(id);
    }
}

