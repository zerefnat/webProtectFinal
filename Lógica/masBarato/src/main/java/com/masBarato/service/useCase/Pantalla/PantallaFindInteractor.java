package com.masBarato.masBarato.service.useCase.Pantalla;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Pantalla;
import com.masBarato.masBarato.service.PantallaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PantallaFindInteractor implements IPantallaFindInteractor{

    private final PantallaService pantallaService;
    @Override
    public Pantalla findPantallaEntityByIdPantalla(Integer pantallaId) {
     return pantallaService.findProcesadorByIdProcesador(pantallaId); 
    }
    
}
