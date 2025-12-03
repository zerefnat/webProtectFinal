package com.masBarato.masBarato.infrastructure.dataBase.sql.mapper;

import com.masBarato.masBarato.domain.model.Rol;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.RolEntity;

public class RolMapper {
    public static Rol fromRoleEntityToRol(RolEntity rolEntity) {
        return new Rol(
                rolEntity.getRolId(),
                rolEntity.getRolName()
        );
    }
}
