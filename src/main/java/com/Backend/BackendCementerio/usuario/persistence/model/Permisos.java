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
@Table(name = "permisos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso")
    private Long idPermiso;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false, unique = true)
    private PermisoEnum permiso;

    @ManyToMany(mappedBy = "permisos", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Rol> roles;
}

