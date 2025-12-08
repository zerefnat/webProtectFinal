package com.masBarato.masBarato.model.classes;

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
}
