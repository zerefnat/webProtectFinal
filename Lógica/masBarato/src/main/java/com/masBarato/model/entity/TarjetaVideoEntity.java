package com.masBarato.masBarato.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tarjeta_video")
public class TarjetaVideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tarjeta_video")
    private Integer idTarjetaVideo;
    @Column(name = "nombre_tarjeta_video")
    private String nombreTarjetaVideo;
}
