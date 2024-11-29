package com.Backend.BackendCementerio.negocio.service;

import com.Backend.BackendCementerio.fallecidos.persistence.models.Fallecido;
import com.Backend.BackendCementerio.fallecidos.persistence.repositories.FallecidoRepository;
import com.Backend.BackendCementerio.negocio.dto.ResponseHorasDto;
import com.Backend.BackendCementerio.negocio.dto.ServicioDTO;
import com.Backend.BackendCementerio.negocio.persistencia.models.DetalleServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.EstadoServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.Servicios;
import com.Backend.BackendCementerio.negocio.persistencia.models.TipoServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.enums.EstadoServicioEnum;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.DetalleServicioRepository;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.EstadoServicioRepository;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.ServicioRepository;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.TipoServicioRepository;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    public boolean verificarMisa(String nombre){
        if(nombre.contains("Misa")){
            return true;
        }
        return false;

    }
    public boolean verificarDiaYHoraReserva(String fecha, String horainicio){
        Servicios servicios = servicioRepository.findByNombre("Misa").get();
        return detalleServicioRepository.existsByServiciosAndFechaReservaAndHoraInicio(servicios, fecha, horainicio);
    }

    public List<ResponseHorasDto> obtenerHorasReservadas(String fecha){
        List<DetalleServicio> detalleServicio= detalleServicioRepository.findAllByFechaReserva(fecha);
        List<ResponseHorasDto> response = new ArrayList<>();
        for (DetalleServicio detalleServicio1 : detalleServicio) {
            ResponseHorasDto dto = new ResponseHorasDto();
            dto.setHoraInicio(detalleServicio1.getHoraInicio());
            dto.setHoraFin(detalleServicio1.getHoraFin());
            response.add(dto);
        }
        return response;
    }

    public DetalleServicio registrarServicio(ServicioDTO negocio){

        String servicioNombre = validarTipoDeServicio(negocio.getNombreServicio());
        Servicios servicio = servicioRepository.findByNombre(servicioNombre)
                .orElseThrow(() -> new IllegalArgumentException("No existe el servicio con nombre: " + negocio.getNombreServicio()));
        TipoServicio tipoServicio = tipoServicioRepository.findByTipoServicio(negocio.getNombreServicio()).get();
        List<TipoServicio> listaServicios = new ArrayList<>();
        listaServicios.add(tipoServicio);
        servicio.setTipoServicio(listaServicios);

        // Buscar y validar entidades requeridas
        Usuario usuario = usuarioRepository.findByCorreo(negocio.getCorreoUsuario())
                .orElseThrow(() -> new IllegalArgumentException("No existe el usuario con correo: " + negocio.getCorreoUsuario()));

        Fallecido fallecido = fallecidoRepository.findByUsuario_CorreoAndIdFallecido(negocio.getCorreoUsuario(), negocio.getIdFallecido())
                .orElseThrow(() -> new IllegalArgumentException("No existe el fallecido con nombre: " + negocio.getIdFallecido()));


        EstadoServicio estadoServicio = estadoServicioRepository.findByEstado(EstadoServicioEnum.EN_PROCESO)
                .orElseThrow(() -> new IllegalArgumentException("No existe el estado de servicio 'EN_PROCESO'"));


        //Almacenamos los datos en la BD de detalle servicio
        DetalleServicio detalleServicio = new DetalleServicio();

        detalleServicio.setFechaReserva(negocio.getFechaReserva());
        detalleServicio.setHoraInicio(negocio.getHoraInicio());
        detalleServicio.setHoraFin(negocio.getHoraFin());
        detalleServicio.setIntencion(negocio.getIntencion());
        detalleServicio.setTotalPagar(tipoServicio.getCosto());

        detalleServicio.setServicios(servicio);
        detalleServicio.setFallecido(fallecido);
        detalleServicio.setEstadoServicio(estadoServicio);
        detalleServicio.setUsuario(usuario);

        return detalleServicioRepository.save(detalleServicio);

    }

    public String validarTipoDeServicio(String servicio){
        String serv = "";
        if(servicio.contains("Misa")){
            serv = "Misa";
        }else if(servicio.contains("Nicho")){
            serv = "Nicho";
        }
        return serv;
    }
    //encontrar usuario por correo
    public Usuario encontrarUsuario(String correo){
        return usuarioRepository.findByCorreo(correo)
                .orElseThrow(()-> new IllegalArgumentException("No hay este usuario"));
    }

    //Traer las reservas por usuario
    public List<DetalleServicio> reservaDeUsuario(Usuario usuario){
        return detalleServicioRepository.findAllByUsuario(usuario);

    }


}
