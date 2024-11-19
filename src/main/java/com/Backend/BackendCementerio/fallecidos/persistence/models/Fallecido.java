
package com.Backend.BackendCementerio.fallecidos.persistence.models;

import com.Backend.BackendCementerio.usuario.persistence.model.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fallecido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fallecido")
    private Long idFallecido;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellidos;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private Date fechaFallecimiento;

    @OneToOne
    @JoinColumn(name = "id_tumba", referencedColumnName = "id_tumba")
    private Tumba tumba;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference
    private Usuario usuario; // Relación inversa


}