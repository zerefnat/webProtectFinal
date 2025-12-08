package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.SistemaOperativoEntity;

public interface SistemaOperativoJpaRepository extends JpaRepository<SistemaOperativoEntity, Integer> {
    SistemaOperativoEntity findSistemaOperativoEntityByIdSO(Integer idProcesador);

}
