package com.Backend.BackendCementerio.usuario.persistence.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.Backend.BackendCementerio.fallecidos.persistence.models.Fallecido;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    private String googleId;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol rol;


    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Fallecido> fallecidos;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (rol != null) {
            return Collections.singletonList(new SimpleGrantedAuthority(rol.getRol().toString()));
        } else {
            System.out.println("El rol esta nulo");
            return Collections.emptyList();
        }
    }

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Definir lógica si es necesario
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Definir lógica si es necesario
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Definir lógica si es necesario
    }

    @Override
    public boolean isEnabled() {
        return true; // Definir lógica si es necesario
    }
}
