package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.MarcaEntity;


public interface MarcaJpaRepository extends JpaRepository<MarcaEntity, Integer> {
    MarcaEntity findMarcaEntitiesByIdMarca(Integer idMarca);
}
