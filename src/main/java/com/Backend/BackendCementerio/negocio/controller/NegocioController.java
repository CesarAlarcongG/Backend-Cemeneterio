package com.Backend.BackendCementerio.negocio.controller;

import com.Backend.BackendCementerio.negocio.dto.ServicioDTO;
import com.Backend.BackendCementerio.negocio.persistencia.models.DetalleServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.Servicios;
import com.Backend.BackendCementerio.negocio.service.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/servicio")
public class NegocioController {
    @Autowired
    private NegocioService negocioService;

    @PostMapping
    public ResponseEntity<?> reservarServicio(@RequestBody ServicioDTO servicio){
        DetalleServicio negocio = negocioService.registrarServicio(servicio);
        if( negocio == null){
            return new ResponseEntity<>("No se puedo reservar el servicio", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(negocio, HttpStatus.CREATED);

    }

}
