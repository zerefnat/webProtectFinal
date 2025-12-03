package com.masBarato.masBarato.infrastructure.dataBase.sql.mapper;

import com.masBarato.masBarato.domain.model.Marca;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.MarcaEntity;

public class MarcaMapper {
    public static Marca fromMarcaEntityToMarca(MarcaEntity marcaEntity) {
        return new Marca(
          marcaEntity.getIdMarca(),
          marcaEntity.getNombreMarca()
        );
    }
}
