package com.masBarato.masBarato.infrastructure.dataBase.sql.repository;

import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarcaJpaRepository extends JpaRepository<MarcaEntity, Integer> {
    MarcaEntity findMarcaEntitiesByIdMarca(Integer idMarca);
}
