package com.masBarato.masBarato.service;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.MarcaMapper;
import com.masBarato.masBarato.mapper.ProcesadorMapper;
import com.masBarato.masBarato.model.classes.Procesador;
import com.masBarato.masBarato.model.entity.ProcesadorEntity;
import com.masBarato.masBarato.repository.ProcesadorJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProcesadorService {
    private final ProcesadorJpaRepository jpaProcesador;

    public Procesador findProcesadorByIdProcesador(Integer idProcesador) {
        ProcesadorEntity procesadorEntity = jpaProcesador.findProcesadorEntityByProcesadorId(idProcesador);
        return ProcesadorMapper.fromProcesadorEntityToProcesador(procesadorEntity);
    }
}
