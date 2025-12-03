package com.masBarato.masBarato.infrastructure.dataBase.sql.repository;

import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.AlmacenamientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenamientoJpaRepository extends JpaRepository<AlmacenamientoEntity, Integer> {
    AlmacenamientoEntity findAlmacenamientoEntityByIdAlmacenamiento(Integer idAlmacenamiento);
}
