package com.masBarato.masBarato.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.RolMapper;
import com.masBarato.masBarato.model.classes.Rol;
import com.masBarato.masBarato.model.entity.RolEntity;
import com.masBarato.masBarato.repository.RolJpaRepository;

@Component
@RequiredArgsConstructor
public class RolServices {
    private final RolJpaRepository jpaRepository;

    public Rol findRolByRoleId(Integer rolId) {
        RolEntity rolEntity = jpaRepository.findRolEntityByRolId(rolId);
        return RolMapper.fromRoleEntityToRol(rolEntity);
    }
}
