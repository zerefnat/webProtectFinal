package com.masBarato.masBarato.service;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.PantallaMapper;
import com.masBarato.masBarato.mapper.SistemaOperativoMapper;
import com.masBarato.masBarato.model.classes.Pantalla;
import com.masBarato.masBarato.model.classes.SistemaOparativo;
import com.masBarato.masBarato.model.entity.PantallaEntity;
import com.masBarato.masBarato.model.entity.SistemaOperativoEntity;
import com.masBarato.masBarato.repository.PantallaJpaRepository;
import com.masBarato.masBarato.repository.SistemaOperativoJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PantallaService {
    private final PantallaJpaRepository jpaProcesador;

    public Pantalla findProcesadorByIdProcesador(Integer idProcesador) {
        PantallaEntity procesadorEntity = jpaProcesador.findPantallaEntityByIdPantalla(idProcesador);
        return PantallaMapper.fromMPantallaEntityToPantalla(procesadorEntity);
    }
}
