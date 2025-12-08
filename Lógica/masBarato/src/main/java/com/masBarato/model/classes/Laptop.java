package com.masBarato.masBarato.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Laptop {
    private String serialNumber;
    private String laptopModel;
    private Date laptopDate;
    private String urlImagen;
    private String description;
    private Float precio;
    private Float descuento;
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
    private String userId;

    public Laptop() {}
}
