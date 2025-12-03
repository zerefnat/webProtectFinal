package com.masBarato.masBarato.infrastructure.dataBase.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="marca")
public class MarcaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_marca")
    private Integer idMarca;
    @Column(name = "nombre_marca")
    private String nombreMarca;
}
