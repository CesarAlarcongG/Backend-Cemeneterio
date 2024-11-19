package com.Backend.BackendCementerio.usuario.persistence.repositoy;

import com.Backend.BackendCementerio.usuario.persistence.model.Enums.PermisoEnum;
import com.Backend.BackendCementerio.usuario.persistence.model.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermisosRepository extends JpaRepository<Permisos, Long> {
    Permisos findByPermiso(PermisoEnum permisoEnum);
}
