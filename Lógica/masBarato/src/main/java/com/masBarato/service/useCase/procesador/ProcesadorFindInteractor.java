package com.masBarato.masBarato.service.useCase.procesador;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Procesador;
import com.masBarato.masBarato.service.ProcesadorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ProcesadorFindInteractor implements IProcesadorFindInteractor {
    private final ProcesadorService procesador;

    @Override
    public Procesador findProcesadorByIdProcesador(Integer idProcesador) {
         return procesador.findProcesadorByIdProcesador(idProcesador);
    }

}
