package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import com.masBarato.masBarato.domain.model.Rol;
import com.masBarato.masBarato.domain.repository.IRolRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.RolEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.RolMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.RolJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolRepositoryAdapter implements IRolRepositoryPort {
    private final RolJpaRepository jpaRepository;

    @Override
    public Rol findRolByRoleId(Integer rolId) {
        RolEntity rolEntity = jpaRepository.findRolEntityByRolId(rolId);
        return RolMapper.fromRoleEntityToRol(rolEntity);
    }
}
