package com.Backend.BackendCementerio.negocio.service;

import com.Backend.BackendCementerio.fallecidos.persistence.models.Fallecido;
import com.Backend.BackendCementerio.fallecidos.persistence.repositories.FallecidoRepository;
import com.Backend.BackendCementerio.negocio.dto.ServicioDTO;
import com.Backend.BackendCementerio.negocio.persistencia.models.DetalleServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.EstadoServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.Servicios;
import com.Backend.BackendCementerio.negocio.persistencia.models.enums.EstadoServicioEnum;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.DetalleServicioRepository;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.EstadoServicioRepository;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.ServicioRepository;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NegocioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private FallecidoRepository fallecidoRepository;
    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private EstadoServicioRepository estadoServicioRepository;
    @Autowired
    private DetalleServicioRepository detalleServicioRepository;


    public DetalleServicio registrarServicio(ServicioDTO negocio){

        // Buscar y validar entidades requeridas
        Usuario usuario = usuarioRepository.findByCorreo(negocio.getCorreoUsuario())
                .orElseThrow(() -> new IllegalArgumentException("No existe el usuario con correo: " + negocio.getCorreoUsuario()));

        Fallecido fallecido = fallecidoRepository.findByUsuario_CorreoAndNombre(negocio.getCorreoUsuario(), negocio.getNombreFallecido())
                .orElseThrow(() -> new IllegalArgumentException("No existe el fallecido con nombre: " + negocio.getNombreFallecido()));

        Servicios servicio = servicioRepository.findByNombre(negocio.getNombreServicio())
                .orElseThrow(() -> new IllegalArgumentException("No existe el servicio con nombre: " + negocio.getNombreServicio()));

        EstadoServicio estadoServicio = estadoServicioRepository.findByEstado(EstadoServicioEnum.EN_PROCESO)
                .orElseThrow(() -> new IllegalArgumentException("No existe el estado de servicio 'EN_PROCESO'"));


        //Almacenamos los datos en la BD de detalle servicio
        DetalleServicio detalleServicio = new DetalleServicio();

        detalleServicio.setFechaReserva(negocio.getFechaReserva());
        detalleServicio.setHoraInicio(negocio.getHoraInicio());
        detalleServicio.setHoraFin(negocio.getHoraFin());
        detalleServicio.setIntencion(negocio.getIntencion());
        detalleServicio.setTotalPagar(servicio.getCosto());

        detalleServicio.setServicios(servicio);
        detalleServicio.setFallecido(fallecido);
        detalleServicio.setEstadoServicio(estadoServicio);
        detalleServicio.setUsuario(usuario);

        return detalleServicioRepository.save(detalleServicio);

    }



}
