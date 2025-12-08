package com.masBarato.masBarato.service.useCase.distribucionTeclado;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.DistribucionTeclado;
import com.masBarato.masBarato.service.DistribucionTecladoServices;

@RequiredArgsConstructor
@Component
public class DistribucionTecladoFindInteractor implements IDistribucionTecladoFindInteractor{
    private final DistribucionTecladoServices tecladoService;

    @Override
    public DistribucionTeclado findDistribucionTecladoById(Integer id) {
        return tecladoService.findDistribucionTecladoById(id);
    }
}
