package com.Backend.BackendCementerio.usuario.persistence.model;

import com.Backend.BackendCementerio.usuario.persistence.model.Enums.PermisoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permisos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPermiso;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private PermisoEnum permiso;

    @ManyToMany(mappedBy = "permisos")
    @JsonBackReference
    private Set<Rol> roles;
}
