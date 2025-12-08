package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.Procesador;
import com.masBarato.masBarato.model.classes.TarjetaVideo;
import com.masBarato.masBarato.model.entity.ProcesadorEntity;
import com.masBarato.masBarato.model.entity.TarjetaVideoEntity;

public class TarjetaVideoMapper {
    public static TarjetaVideo fromTarjetaEntityToTarjeta(TarjetaVideoEntity marcaEntity) {
        return new TarjetaVideo(
            marcaEntity.getIdTarjetaVideo(),
            marcaEntity.getNombreTarjetaVideo()
        );
    }
}
