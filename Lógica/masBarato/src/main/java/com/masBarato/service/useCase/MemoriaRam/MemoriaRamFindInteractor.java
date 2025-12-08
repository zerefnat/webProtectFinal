package com.masBarato.masBarato.service.useCase.MemoriaRam;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Marca;
import com.masBarato.masBarato.model.classes.MemoriaRam;
import com.masBarato.masBarato.service.MemoriaRamService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MemoriaRamFindInteractor implements IMemoriaRamFindInteractor{
    private final MemoriaRamService memoServices;

    @Override
    public MemoriaRam findMemoriaRamByIdMemoriaRam(Integer idMarca) {
         return memoServices.findProcesadorByIdProcesador(idMarca);
    }
    
}
