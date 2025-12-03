package com.masBarato.masBarato.infrastructure.dataBase.sql.repository;

import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolJpaRepository extends JpaRepository<RolEntity, Integer> {
    RolEntity findRolEntityByRolId(Integer rolId);

}
