package com.Backend.BackendCementerio.usuario.persistence.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByCorreo(String correo);
    Usuario findByCorreoAndContraseña(String correo, String contrseña);
}
