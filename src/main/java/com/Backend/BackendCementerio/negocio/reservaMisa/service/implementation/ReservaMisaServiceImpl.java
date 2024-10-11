package com.Backend.BackendCementerio.negocio.reservaMisa.service.implementation;

import com.Backend.BackendCementerio.negocio.persistencia.models.ReservaMisa;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.IReservaMisaRepository;
import com.Backend.BackendCementerio.negocio.reservaMisa.service.interfaces.IReservaMisaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaMisaServiceImpl implements IReservaMisaService {

    @Autowired
    private IReservaMisaRepository reservaMisaRepository;

    @Override
    public List<ReservaMisa> findAll() {
        return reservaMisaRepository.findAll();
    }

    @Override
    public ReservaMisa findById(Long id) {
        return reservaMisaRepository.findById(id).orElse(null);
    }

    @Override
    public ReservaMisa save(ReservaMisa reservaMisa) {
        return reservaMisaRepository.save(reservaMisa);
    }

    @Override
    public void delete(Long id) {
        reservaMisaRepository.deleteById(id);
    }
}
