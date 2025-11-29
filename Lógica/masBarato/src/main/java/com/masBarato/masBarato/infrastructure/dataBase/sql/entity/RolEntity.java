package com.masBarato.masBarato.infrastructure.dataBase.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rol")
    private Integer RolId;
    @Column(name = "nombre_rol")
    private String RolName;
}
