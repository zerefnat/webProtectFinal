package com.masBarato.masBarato.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="usuario_eliminado")
public class UserDeletedEntity {

    @Id
    @Column(name = "username")
    private String userId;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido_uno")
    private String firstLastName;
    @Column(name = "apellido_dos")
    private String secondLastName;
    private String gmail;
    @Column(name = "contrasennia")
    private String password;
    @ManyToOne
    @JoinColumn(name = "fk_rol", referencedColumnName = "id_rol")
    private RolEntity rol;
    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "username")
    private UserEntity fkUserId;
}
