package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.masBarato.masBarato.model.entity.ProcesadorEntity;

public interface ProcesadorJpaRepository extends JpaRepository<ProcesadorEntity, Integer> {
    ProcesadorEntity findProcesadorEntityByProcesadorId(Integer idProcesador);

}
