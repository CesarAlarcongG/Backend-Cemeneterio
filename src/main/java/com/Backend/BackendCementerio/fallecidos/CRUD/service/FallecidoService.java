package com.Backend.BackendCementerio.fallecidos.CRUD.service;

import com.Backend.BackendCementerio.fallecidos.CRUD.dto.FallecidoDTO;
import com.Backend.BackendCementerio.fallecidos.persistence.models.Fallecido;
import com.Backend.BackendCementerio.fallecidos.persistence.repositories.FallecidoRepository;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FallecidoService {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private FallecidoRepository fallecidoRepository;

    public List<Fallecido> traerFallecidosDeUsuarios(String correo) {
        Usuario usuario = usuarioRepository.findByCorreo(correo).get();

        List<Fallecido> fallecidos = fallecidoRepository.findByUsuario(usuario);

        return fallecidos;
    }

    public Optional<Fallecido> getFallecidoById(Long id) {
        return fallecidoRepository.findById(id);
    }

    public Usuario crearFallecido(FallecidoDTO fallecidoDTO) {
        // Buscar al usuario por correo
        Usuario usuario = usuarioRepository.findByCorreo(fallecidoDTO.getCorreo())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Crear el nuevo fallecido
        Fallecido fallecido = new Fallecido();
        fallecido.setNombre(fallecidoDTO.getNombre());
        fallecido.setApellidos(fallecidoDTO.getApellidos());
        fallecido.setFechaNacimiento(fallecidoDTO.getFechaNacimiento());
        fallecido.setFechaFallecimiento(fallecidoDTO.getFechaFallecimiento());

        // Establecer la relación inversa
        fallecido.setUsuario(usuario);

        // Asociar el fallecido al usuario
        usuario.getFallecidos().add(fallecido);

        // Guardar ambos
        fallecidoRepository.save(fallecido); // Guardar el Fallecido
        usuarioRepository.save(usuario); // Guardar el Usuario

        return usuario;
    }

    public Fallecido updateFallecido(Long id, Fallecido fallecido) {
        fallecido.setIdFallecido(id);
        return fallecidoRepository.save(fallecido);
    }

    public void deleteFallecido(Long id) {
        fallecidoRepository.deleteById(id);
    }
}
