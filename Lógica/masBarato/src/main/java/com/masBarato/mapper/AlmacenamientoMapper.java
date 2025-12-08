package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.Almacenamiento;
import com.masBarato.masBarato.model.entity.AlmacenamientoEntity;

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
