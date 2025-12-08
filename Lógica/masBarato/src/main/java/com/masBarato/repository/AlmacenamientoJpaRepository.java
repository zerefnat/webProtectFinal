package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.AlmacenamientoEntity;

public interface AlmacenamientoJpaRepository extends JpaRepository<AlmacenamientoEntity, Integer> {
    AlmacenamientoEntity findAlmacenamientoEntityByIdAlmacenamiento(Integer idAlmacenamiento);
}
