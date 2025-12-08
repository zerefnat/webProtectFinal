package com.masBarato.masBarato.service.useCase.TarjetaVideo;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.TarjetaVideo;
import com.masBarato.masBarato.service.TarjetaVideoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TarjetaVideoFindInteractor implements ITarjetaVideoFindInteractor{

    private final TarjetaVideoService tarjeta;
    @Override
    public TarjetaVideo findTarjetaByIdTarjeta(Integer idTarjeta) {
         return tarjeta.findTarjetaVideoByTarjetaVideo(idTarjeta);
    }
    
}
