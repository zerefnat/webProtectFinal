package com.masBarato.masBarato.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Laptop {
    private Integer laptopId;
    private String laptopModel;
    private Date laptopDate;
    private String urlImagen;
    private Integer marca;
    private Integer procesador;
    private Integer pantalla;
    private Integer distribucionTeclado;
    private Integer almacenamiento;
    private Integer sistemaOperativo1;
    private Integer sistemaOperativo2;
    private Integer memoriaRam1;
    private Integer memoriaRam2;
    private Integer tarjetaVideo;
    private Integer userId;

    public Laptop() {}
}
