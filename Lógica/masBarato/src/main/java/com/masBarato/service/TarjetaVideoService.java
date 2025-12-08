package com.masBarato.masBarato.service;

import com.masBarato.masBarato.mapper.TarjetaVideoMapper;
import com.masBarato.masBarato.model.classes.TarjetaVideo;
import com.masBarato.masBarato.model.entity.TarjetaVideoEntity;
import com.masBarato.masBarato.repository.TarjetaVideoJpaRepository;

public class TarjetaVideoService {
    private final TarjetaVideoJpaRepository jpaProcesador = null;

    public TarjetaVideo findTarjetaVideoByTarjetaVideo(Integer idProcesador) {
        TarjetaVideoEntity procesadorEntity = jpaProcesador.findTarjetaVideoEntityByIdTarjetaVideo(idProcesador);
        return TarjetaVideoMapper.fromTarjetaEntityToTarjeta(procesadorEntity);
    }
    
}
