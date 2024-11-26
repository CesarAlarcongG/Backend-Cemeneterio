package com.Backend.BackendCementerio.fallecidos.persistence.repositories;

import com.Backend.BackendCementerio.fallecidos.persistence.models.Fallecido;
import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FallecidoRepository extends JpaRepository<Fallecido, Long> {
    Optional<Fallecido> findByNombre(String nombre);

    Optional<Fallecido> findByUsuario_CorreoAndIdFallecido(String correoUsuario, Long idFallecido);

    List<Fallecido> findByUsuario(Usuario usuario);
}
