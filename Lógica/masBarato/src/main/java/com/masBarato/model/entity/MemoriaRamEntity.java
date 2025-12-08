package com.masBarato.masBarato.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="memoria_ram")
public class MemoriaRamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_memoria_ram")
    private Integer idMemoria;
    @Column(name="nombre_ram")
    private String name;
}
