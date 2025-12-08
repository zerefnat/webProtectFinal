package com.masBarato.masBarato.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="sistema_operativo")
public class SistemaOperativoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_sistema_operativo")
    private Integer idSO;
    @Column(name ="nombre_sistema_operativo")
    private String nombreSO;
}
