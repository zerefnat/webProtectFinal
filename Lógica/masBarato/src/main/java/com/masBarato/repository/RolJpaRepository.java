package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.RolEntity;

public interface RolJpaRepository extends JpaRepository<RolEntity, Integer> {
    RolEntity findRolEntityByRolId(Integer rolId);

}
