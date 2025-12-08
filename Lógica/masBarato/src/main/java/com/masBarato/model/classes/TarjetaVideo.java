package com.masBarato.masBarato.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TarjetaVideo {
    private Integer idTarjetaVideo;
    private String nombreTarjetaVideo;
    private Integer idTarjeta;
    private String nombre;
}
