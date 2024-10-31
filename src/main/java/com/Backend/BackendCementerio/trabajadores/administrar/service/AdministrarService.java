package com.Backend.BackendCementerio.trabajadores.administrar.service;

import com.Backend.BackendCementerio.trabajadores.administrar.dto.TrabajadorDTO;
import com.Backend.BackendCementerio.trabajadores.persistencia.model.Cargo;
import com.Backend.BackendCementerio.trabajadores.persistencia.model.Trabajador;
import com.Backend.BackendCementerio.trabajadores.persistencia.repository.CargoRepository;
import com.Backend.BackendCementerio.trabajadores.persistencia.repository.TrabajadorRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministrarService {


    @Autowired
    private TrabajadorRespository trabajadorRepository;
    @Autowired
    private CargoRepository cargoRepository;

    @Transactional
    public boolean crearTrabajador(TrabajadorDTO trabajadorDTO) {
        Trabajador trabajador = new Trabajador();
        trabajador.setNombre(trabajadorDTO.getNombre());
        trabajador.setApellido(trabajadorDTO.getApellido());
        trabajador.setDni(trabajadorDTO.getDni());

        if (trabajadorDTO.getCargo() != null) {
            Cargo cargo = new Cargo();
            cargo.setCargo(trabajadorDTO.getCargo().getCargo());
            cargo.setHoraEntrada(trabajadorDTO.getCargo().getHoraEntrada());
            cargo.setHoraSalida(trabajadorDTO.getCargo().getHoraSalida());

            Cargo cargoGuardado = cargoRepository.save(cargo);
            trabajador.setCargo(cargoGuardado);
        }

        try {
            Trabajador guardado = trabajadorRepository.save(trabajador);
            return guardado != null;
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el stack trace para obtener más información sobre el error
            return false;
        }
    }

    public Optional<Trabajador> obtenerTrabajadorPorDni(Long dni) {
        return trabajadorRepository.findByDni(dni); // Asumiendo que has definido este método en el repositorio
    }

    public Iterable<Trabajador> obtenerTodosLosTrabajadores() {
        return trabajadorRepository.findAll();
    }

    public boolean actualizarTrabajador(TrabajadorDTO trabajadorDTO) {
        Optional<Trabajador> optionalTrabajador = trabajadorRepository.findByDni(trabajadorDTO.getDni());

        if (optionalTrabajador.isPresent()) {
            Trabajador trabajador = optionalTrabajador.get();

            // Actualiza solo el nombre y apellido si se proporcionan
            if (trabajadorDTO.getNombre() != null) {
                trabajador.setNombre(trabajadorDTO.getNombre());
            }
            if (trabajadorDTO.getApellido() != null) {
                trabajador.setApellido(trabajadorDTO.getApellido());
            }

            // Verifica si se proporciona un objeto Cargo en el DTO
            if (trabajadorDTO.getCargo() != null) {
                Optional<Cargo> cargoOptional = cargoRepository.findById(trabajadorDTO.getCargo().getId());
                if (cargoOptional.isPresent()) {
                    Cargo cargoExistente = cargoOptional.get();

                    // Actualiza los campos de Cargo si han cambiado
                    if (trabajadorDTO.getCargo().getCargo() != null) {
                        cargoExistente.setCargo(trabajadorDTO.getCargo().getCargo());
                    }
                    if (trabajadorDTO.getCargo().getHoraEntrada() != null) {
                        cargoExistente.setHoraEntrada(trabajadorDTO.getCargo().getHoraEntrada());
                    }
                    if (trabajadorDTO.getCargo().getHoraSalida() != null) {
                        cargoExistente.setHoraSalida(trabajadorDTO.getCargo().getHoraSalida());
                    }

                    trabajador.setCargo(cargoExistente);
                } else {
                    throw new IllegalArgumentException("Cargo no encontrado con el id: " + trabajadorDTO.getCargo().getId());
                }
            }

            // Guarda el trabajador con los campos actualizados
            trabajadorRepository.save(trabajador);
            return true;
        }
        return false;
    }



    public boolean eliminarTrabajador(Long dni) {
        Optional<Trabajador> trabajador = trabajadorRepository.findByDni(dni);
        if (trabajador.isPresent()) {
            trabajadorRepository.delete(trabajador.get());
            return true;
        }
        return false;
    }
}
