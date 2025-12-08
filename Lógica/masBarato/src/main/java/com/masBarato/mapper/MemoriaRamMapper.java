package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.MemoriaRam;
import com.masBarato.masBarato.model.classes.Procesador;
import com.masBarato.masBarato.model.entity.MemoriaRamEntity;
import com.masBarato.masBarato.model.entity.ProcesadorEntity;

public class MemoriaRamMapper {
    public static MemoriaRam fromMemoriaRamEntityToMemoriaRam(MemoriaRamEntity marcaEntity) {
        return new MemoriaRam(
          marcaEntity.getIdMemoria(),
          marcaEntity.getName()
        );
    }
}
