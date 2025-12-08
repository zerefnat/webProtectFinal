package com.masBarato.masBarato.service.useCase.almacenamiento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Almacenamiento;
import com.masBarato.masBarato.service.AlmacenamientoServices;

@RequiredArgsConstructor
@Component
public class AlmacenamientoFindInteractor implements IAlmacenamientoFindInteractor{
    private final  AlmacenamientoServices almacenamientoService;

    @Override
    public Almacenamiento findAlmacenamientoByIdAlmacenamiento(Integer idAlmacenamiento) {
        return almacenamientoService.findAlmacenamientoByIdAlmacenamiento(idAlmacenamiento);
    }
}
