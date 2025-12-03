package com.masBarato.masBarato.infrastructure.dataBase.sql.mapper;

import com.masBarato.masBarato.domain.model.Almacenamiento;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.AlmacenamientoEntity;

public class AlmacenamientoMapper {
    public static Almacenamiento fromAlmacenamientoEntityToAlmacenamiento(AlmacenamientoEntity almacenamientoEntity) {
        return new Almacenamiento(
                almacenamientoEntity.getIdAlmacenamiento(),
                almacenamientoEntity.getNombreTipoAlmacenamiento(),
                almacenamientoEntity.getTamanioAlmacenamiento(),
                almacenamientoEntity.getUnidadMedidaTamanioAlmacenamiento()
        );
    }
}
