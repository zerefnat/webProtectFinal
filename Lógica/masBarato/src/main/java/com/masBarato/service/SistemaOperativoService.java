package com.masBarato.masBarato.service;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.ProcesadorMapper;
import com.masBarato.masBarato.mapper.SistemaOperativoMapper;
import com.masBarato.masBarato.model.classes.SistemaOparativo;
import com.masBarato.masBarato.model.entity.SistemaOperativoEntity;
import com.masBarato.masBarato.repository.SistemaOperativoJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SistemaOperativoService {
    private final SistemaOperativoJpaRepository jpaProcesador;

    public SistemaOparativo findProcesadorByIdProcesador(Integer idProcesador) {
        SistemaOperativoEntity procesadorEntity = jpaProcesador.findSistemaOperativoEntityByIdSO(idProcesador);
        return SistemaOperativoMapper.fromProcesadorEntityToProcesador(procesadorEntity);
    }
}
