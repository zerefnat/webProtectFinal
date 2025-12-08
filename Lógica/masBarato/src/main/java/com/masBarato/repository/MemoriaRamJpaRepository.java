package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.MemoriaRamEntity;

public interface MemoriaRamJpaRepository extends JpaRepository<MemoriaRamEntity, Integer> {
    MemoriaRamEntity findMemoriaRamEntityByIdMemoria(Integer idProcesador);

}
