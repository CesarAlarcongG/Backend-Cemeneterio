package com.Backend.BackendCementerio.negocio.controller;

import com.Backend.BackendCementerio.negocio.dto.ResponseHorasDto;
import com.Backend.BackendCementerio.negocio.dto.ServicioDTO;
import com.Backend.BackendCementerio.negocio.persistencia.models.DetalleServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.Servicios;
import com.Backend.BackendCementerio.negocio.service.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicio")
public class NegocioController {
    @Autowired
    private NegocioService negocioService;

    @PostMapping()
    public ResponseEntity<?> reservarServicio(@RequestBody ServicioDTO servicio){

        //Verifiucamos si es una misa
        if (negocioService.verificarMisa(servicio.getNombreServicio())){

            //Verificamos si ya hay una reserva ese día y a esa hora
            if (negocioService.verificarDiaYHoraReserva(servicio.getFechaReserva(), servicio.getHoraInicio())){
                List<ResponseHorasDto> horaReservado = negocioService.obtenerHorasReservadas(servicio.getFechaReserva());
                return new ResponseEntity<>(horaReservado, HttpStatus.CONFLICT);
            }
        }

        DetalleServicio negocio = negocioService.registrarServicio(servicio);
        if( negocio == null){
            return new ResponseEntity<>("No se puedo reservar el servicio", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(negocio, HttpStatus.CREATED);

    }


    @GetMapping("/horarios")
    public List<ResponseHorasDto> listaHorasReservadas(@RequestParam String fecha){
     return negocioService.obtenerHorasReservadas(fecha);
    }

}
