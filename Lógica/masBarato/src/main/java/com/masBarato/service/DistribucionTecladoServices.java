package com.masBarato.masBarato.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.DistribucionTecladoMapper;
import com.masBarato.masBarato.model.classes.DistribucionTeclado;
import com.masBarato.masBarato.model.entity.DistribucionTecladoEntity;
import com.masBarato.masBarato.repository.DistribucionTecladoJpaRepository;

@RequiredArgsConstructor
@Component
public class DistribucionTecladoServices {
    private final DistribucionTecladoJpaRepository jpaRepository;

    public DistribucionTeclado findDistribucionTecladoById(Integer id) {
        DistribucionTecladoEntity dt = jpaRepository.findDistribucionTecladoEntitiesById(id);
        return DistribucionTecladoMapper.fromDTEntityToDt(dt);
    }
}
