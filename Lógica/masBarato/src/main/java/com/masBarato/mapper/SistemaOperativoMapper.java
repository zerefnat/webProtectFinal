package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.Procesador;
import com.masBarato.masBarato.model.classes.SistemaOparativo;
import com.masBarato.masBarato.model.entity.ProcesadorEntity;
import com.masBarato.masBarato.model.entity.SistemaOperativoEntity;

public class SistemaOperativoMapper {
public static SistemaOparativo fromProcesadorEntityToProcesador(SistemaOperativoEntity marcaEntity) {
        return new SistemaOparativo(
          marcaEntity.getIdSO(),
          marcaEntity.getNombreSO()
        );
    }
}
