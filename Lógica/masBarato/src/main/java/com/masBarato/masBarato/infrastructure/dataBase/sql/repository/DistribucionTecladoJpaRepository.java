package com.masBarato.masBarato.infrastructure.dataBase.sql.repository;

import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.DistribucionTecladoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistribucionTecladoJpaRepository extends JpaRepository<DistribucionTecladoEntity, Integer> {
    DistribucionTecladoEntity findDistribucionTecladoEntitiesById(Integer id);
}
