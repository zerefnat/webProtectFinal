package com.masBarato.masBarato.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.MarcaMapper;
import com.masBarato.masBarato.model.classes.Marca;
import com.masBarato.masBarato.model.entity.MarcaEntity;
import com.masBarato.masBarato.repository.MarcaJpaRepository;

@RequiredArgsConstructor
@Component
public class MarcaServices{
    private final MarcaJpaRepository JpaRepository;

    public Marca findMarcaByIdMarca(Integer idMarca) {
        MarcaEntity marcaEntity = JpaRepository.findMarcaEntitiesByIdMarca(idMarca);
        return MarcaMapper.fromMarcaEntityToMarca(marcaEntity);
    }
}
