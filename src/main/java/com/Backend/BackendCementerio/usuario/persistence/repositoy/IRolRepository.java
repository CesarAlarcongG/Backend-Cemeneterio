package com.Backend.BackendCementerio.usuario.persistence.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.BackendCementerio.usuario.persistence.model.Rol;
import com.Backend.BackendCementerio.usuario.persistence.model.RolEnum;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{
    Rol findByRol(RolEnum rol);
}
