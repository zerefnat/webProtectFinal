package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.DistribucionTeclado;
import com.masBarato.masBarato.model.entity.DistribucionTecladoEntity;

public class DistribucionTecladoMapper {
    public static DistribucionTeclado fromDTEntityToDt(DistribucionTecladoEntity dt) {
        return new DistribucionTeclado(
                dt.getId(),
                dt.getNombre()
        );
    }
}
