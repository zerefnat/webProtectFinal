package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.TarjetaVideoEntity;

public interface TarjetaVideoJpaRepository extends JpaRepository<TarjetaVideoEntity, Integer> {
    TarjetaVideoEntity findTarjetaVideoEntityByIdTarjetaVideo(Integer idProcesador);

}
