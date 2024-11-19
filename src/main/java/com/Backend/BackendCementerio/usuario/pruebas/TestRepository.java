package com.Backend.BackendCementerio.usuario.pruebas;

import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Usuario, Long> {
}
