package com.masBarato.masBarato.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="distribucion_teclado")
public class DistribucionTecladoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_distribucion_teclado")
    private Integer id;
    @Column(name="nombre_distribucion_teclado")
    private String nombre;
}
