package com.masBarato.masBarato.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.PantallaEntity;

public interface PantallaJpaRepository extends JpaRepository<PantallaEntity, Integer> {
    PantallaEntity findPantallaEntityByIdPantalla(Integer serialNumber);
}
