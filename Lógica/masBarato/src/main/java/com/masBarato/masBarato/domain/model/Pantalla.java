package com.masBarato.masBarato.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Getter
public class Pantalla {
    private Integer idPantalla;
    private double anchoPantalla;
    private double altoPantalla;
    private TecnologiaPantalla tecnologiaPantalla;
    private boolean esTactil;
    private double alto;
    private double ancho;
}
