package com.Backend.BackendCementerio.usuario.persistence.model;

import com.Backend.BackendCementerio.usuario.persistence.model.Enums.RolEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private RolEnum rol;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Rol_Permisos",
            joinColumns = @JoinColumn(name = "id_rol"),
            inverseJoinColumns = @JoinColumn(name = "id_permiso")
    )
    @JsonManagedReference
    private Set<Permisos> permisos;

}

