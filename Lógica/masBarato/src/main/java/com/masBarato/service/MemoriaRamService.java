package com.masBarato.masBarato.service;

import com.masBarato.masBarato.mapper.MemoriaRamMapper;
import com.masBarato.masBarato.model.classes.MemoriaRam;
import com.masBarato.masBarato.model.entity.MemoriaRamEntity;
import com.masBarato.masBarato.repository.MemoriaRamJpaRepository;

public class MemoriaRamService {
    private final MemoriaRamJpaRepository jpaProcesador = null;

    public MemoriaRam findProcesadorByIdProcesador(Integer idProcesador) {
        MemoriaRamEntity procesadorEntity = jpaProcesador.findMemoriaRamEntityByIdMemoria(idProcesador);
        return MemoriaRamMapper.fromMemoriaRamEntityToMemoriaRam(procesadorEntity);
    }
}
