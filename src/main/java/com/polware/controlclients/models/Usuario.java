package com.polware.controlclients.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.*;

/**
 * Created by IntelliJ IDEA
 * User: Paul H. Vargas P.
 * Date: 7/06/2023
 * Time: 1:29 p. m.
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @OneToMany
    @JoinColumn(name="idRol", referencedColumnName="idUsuario")
    @ToString.Exclude
    private List<Rol> roles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usuario usuario = (Usuario) o;
        return getIdUsuario() != null && Objects.equals(getIdUsuario(), usuario.getIdUsuario());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
