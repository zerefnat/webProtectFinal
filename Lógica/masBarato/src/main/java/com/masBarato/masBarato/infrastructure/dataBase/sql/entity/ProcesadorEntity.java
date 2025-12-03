package com.masBarato.masBarato.infrastructure.dataBase.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="procesador")
public class ProcesadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_procesador")
    private Integer idProcesador;
    @Column(name = "nombre_procesador")
    private String nombreProcesador;
    @Column(name = "nombre")
    private String nombre;
}
