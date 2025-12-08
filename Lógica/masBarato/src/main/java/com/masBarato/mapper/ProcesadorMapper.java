package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.Marca;
import com.masBarato.masBarato.model.classes.Procesador;
import com.masBarato.masBarato.model.entity.MarcaEntity;
import com.masBarato.masBarato.model.entity.ProcesadorEntity;

public class ProcesadorMapper {
    public static Procesador fromProcesadorEntityToProcesador(ProcesadorEntity marcaEntity) {
        return new Procesador(
          marcaEntity.getIdProcesador(),
          marcaEntity.getNombreProcesador()
        );
    }
}
