package com.masBarato.masBarato.infrastructure.dataBase.sql.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Table(name = "usuario")
@Entity
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer userId;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido_uno")
    private String firstLastName;
    @Column(name = "apellido_dos")
    private String secondLastName;
    private String gmail;
    @Column(name = "username")
    private String userName;
    @Column(name = "contrasennia")
    private String password;
    @ManyToOne
    @JoinColumn(name = "fk_rol", referencedColumnName = "id_rol")
    private RolEntity rol;
    @ManyToOne
    @JoinColumn(name="fk_usuario",referencedColumnName = "id_usuario")
    private UserEntity fkUserId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.getRolName()));
    }
    @Override
    public String getUsername() {
        return this.userName;
    }
}
