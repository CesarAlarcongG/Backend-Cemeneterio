package com.Backend.BackendCementerio.trabajadores.asistencia.services;

import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import com.Backend.BackendCementerio.trabajadores.persistencia.repository.TrabajadorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRespository trabajadorRespository;

    public Optional<Trabajador> findByDni(Long codigo) {
        return trabajadorRespository.findByDni(codigo);
    }
    public List<Trabajador> obtenerTrabajadores(){
        return trabajadorRespository.findAll();
    }

    public boolean crearTranajador(List<Trabajador> trabajador){
        try{
            trabajadorRespository.saveAll(trabajador);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}

