package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.Rol;
import com.masBarato.masBarato.model.entity.RolEntity;

public class RolMapper {
    public static Rol fromRoleEntityToRol(RolEntity rolEntity) {
        return new Rol(
                rolEntity.getRolId(),
                rolEntity.getRolName()
        );
    }
}
