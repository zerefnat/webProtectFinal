package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.DistribucionTecladoEntity;

public interface DistribucionTecladoJpaRepository extends JpaRepository<DistribucionTecladoEntity, Integer> {
    DistribucionTecladoEntity findDistribucionTecladoEntitiesById(Integer id);
}
