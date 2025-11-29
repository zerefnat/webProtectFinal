package com.masBarato.masBarato.infrastructure.dataBase.sql.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "usuario")
@Entity
public class UserEntity {
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
}
