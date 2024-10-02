package com.Backend.BackendCementerio.negocio.reservaMisa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.Backend.BackendCementerio.negocio.persistencia.models.ReservaMisa;
import com.Backend.BackendCementerio.negocio.reservaMisa.service.interfaces.IReservaMisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservamisa")
@CrossOrigin
public class ReservaMisaController {

    @Autowired
    private IReservaMisaService reservaMisaService;

    @GetMapping
    public List<ReservaMisa> getAllReservasMisa() {
        return reservaMisaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaMisa> getReservaMisaById(@PathVariable Long id) {
        ReservaMisa reservaMisa = reservaMisaService.findById(id);
        if (reservaMisa == null) {
            throw new NoSuchElementException("La reserva con el id: " + id + " no existe.");
        }
        return ResponseEntity.ok(reservaMisa);
    }

    @PostMapping
    public ResponseEntity<ReservaMisa> createReservaMisa(@RequestBody ReservaMisa reservaMisa) {
        ReservaMisa savedReservaMisa = reservaMisaService.save(reservaMisa);
        return ResponseEntity.ok(savedReservaMisa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaMisa> updateReservaMisa(@PathVariable Long id, @RequestBody ReservaMisa reservaMisaDetails) {
        ReservaMisa reservaMisa = reservaMisaService.findById(id);
        if (reservaMisa == null) {
            throw new NoSuchElementException("La reserva con el id: " + id + " no existe.");
        }

        reservaMisa.setFechaReserva(reservaMisaDetails.getFechaReserva());
        reservaMisa.setIntencion(reservaMisaDetails.getIntencion());
        reservaMisa.setCosto(reservaMisaDetails.getCosto());
        reservaMisa.setTipoMisa(reservaMisaDetails.getTipoMisa());
        reservaMisa.setTiempoMisa(reservaMisaDetails.getTiempoMisa());
        reservaMisa.setDescripcion(reservaMisaDetails.getDescripcion()); // Actualizar descripcion
        ReservaMisa updatedReservaMisa = reservaMisaService.save(reservaMisa);
        return ResponseEntity.ok(updatedReservaMisa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteReservaMisa(@PathVariable Long id) {
        ReservaMisa reservaMisa = reservaMisaService.findById(id);
        if (reservaMisa == null) {
            throw new NoSuchElementException("La reserva con el id: " + id + " no existe.");
        }
        reservaMisaService.delete(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
