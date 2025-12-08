package com.masBarato.masBarato.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Almacenamiento {
    private Integer idAlmacenamiento;
    private TipoAlmacenamiento tipoAlmacenamiento;
    private Integer tamanioAlmacenamiento;
    private UnidadMedida unidadMedida;
}
