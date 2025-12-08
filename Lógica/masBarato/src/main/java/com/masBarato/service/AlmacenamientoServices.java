package com.masBarato.masBarato.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.AlmacenamientoMapper;
import com.masBarato.masBarato.model.classes.Almacenamiento;
import com.masBarato.masBarato.model.entity.AlmacenamientoEntity;
import com.masBarato.masBarato.repository.AlmacenamientoJpaRepository;

@RequiredArgsConstructor
@Component
public class AlmacenamientoServices{
    private final AlmacenamientoJpaRepository jpaRepository;

    public Almacenamiento findAlmacenamientoByIdAlmacenamiento(Integer idAlmacenamiento) {
        AlmacenamientoEntity almacenamientoEntity = jpaRepository.findAlmacenamientoEntityByIdAlmacenamiento(idAlmacenamiento);
        return AlmacenamientoMapper.fromAlmacenamientoEntityToAlmacenamiento(almacenamientoEntity);
    }
}
