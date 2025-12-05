package com.masBarato.masBarato.infrastructure.dataBase.sql.mapper;

import com.masBarato.masBarato.domain.model.DistribucionTeclado;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.DistribucionTecladoEntity;

public class DistribucionTecladoMapper {
    public static DistribucionTeclado fromDTEntityToDt(DistribucionTecladoEntity dt) {
        return new DistribucionTeclado(
                dt.getId(),
                dt.getNombre()
        );
    }
}
