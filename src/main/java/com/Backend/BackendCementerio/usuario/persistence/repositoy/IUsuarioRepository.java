package com.Backend.BackendCementerio.usuario.persistence.repositoy;

import java.util.Optional;

import com.Backend.BackendCementerio.fallecidos.persistence.models.Fallecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
    //Registro
    Optional<Usuario> findByCorreo(String correo);

}
