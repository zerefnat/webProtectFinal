package com.masBarato.masBarato.service.useCase.SistemaOperativo;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Procesador;
import com.masBarato.masBarato.model.classes.SistemaOparativo;
import com.masBarato.masBarato.service.ProcesadorService;
import com.masBarato.masBarato.service.SistemaOperativoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SistemaOperativoFindInteractor implements ISistemaOperativoFindInteractor {
    private final SistemaOperativoService procesador;

    @Override
    public SistemaOparativo findSOByIdSO(Integer idProcesador) {
        return procesador.findProcesadorByIdProcesador(idProcesador);
    }

}
