package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.Marca;
import com.masBarato.masBarato.model.entity.MarcaEntity;

public class MarcaMapper {
    public static Marca fromMarcaEntityToMarca(MarcaEntity marcaEntity) {
        return new Marca(
          marcaEntity.getIdMarca(),
          marcaEntity.getNombreMarca()
        );
    }
}
