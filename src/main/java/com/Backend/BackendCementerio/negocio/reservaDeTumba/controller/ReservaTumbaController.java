package com.Backend.BackendCementerio.negocio.reservaDeTumba.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.Backend.BackendCementerio.negocio.persistencia.models.ReservaTumba;
import com.Backend.BackendCementerio.negocio.reservaDeTumba.service.interfaces.IReservaTumbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservatumba")
@CrossOrigin
public class ReservaTumbaController {

    @Autowired
    private IReservaTumbaService reservaTumbaService;

    // Obtener todas las reservas de tumba
    @GetMapping
    public List<ReservaTumba> getAllReservasTumba() {
        return reservaTumbaService.findAll();
    }

    // Obtener una reserva de tumba por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservaTumba> getReservaTumbaById(@PathVariable Long id) {
        ReservaTumba reservaTumba = reservaTumbaService.findById(id);
        if (reservaTumba == null) {
            throw new NoSuchElementException("La reserva con el id: " + id + " no existe.");
        }
        return ResponseEntity.ok(reservaTumba);
    }

    // Crear una nueva reserva de tumba
    @PostMapping
    public ResponseEntity<ReservaTumba> createReservaTumba(@RequestBody ReservaTumba reservaTumba) {
        ReservaTumba savedReservaTumba = reservaTumbaService.save(reservaTumba);
        return ResponseEntity.ok(savedReservaTumba);
    }

    // Actualizar una reserva de tumba existente
    @PutMapping("/{id}")
    public ResponseEntity<ReservaTumba> updateReservaTumba(@PathVariable Long id, @RequestBody ReservaTumba reservaTumbaDetails) {
        ReservaTumba reservaTumba = reservaTumbaService.findById(id);
        if (reservaTumba == null) {
            throw new NoSuchElementException("La reserva con el id: " + id + " no existe.");
        }

        reservaTumba.setFechaReserva(reservaTumbaDetails.getFechaReserva());
        reservaTumba.setCosto(reservaTumbaDetails.getCosto());
        reservaTumba.setTipoTumba(reservaTumbaDetails.getTipoTumba());
        reservaTumba.setUbicacionTumba(reservaTumbaDetails.getUbicacionTumba());
        ReservaTumba updatedReservaTumba = reservaTumbaService.save(reservaTumba);
        return ResponseEntity.ok(updatedReservaTumba);
    }

    // Eliminar una reserva de tumba
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteReservaTumba(@PathVariable Long id) {
        ReservaTumba reservaTumba = reservaTumbaService.findById(id);
        if (reservaTumba == null) {
            throw new NoSuchElementException("La reserva con el id: " + id + " no existe.");
        }
        reservaTumbaService.delete(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
