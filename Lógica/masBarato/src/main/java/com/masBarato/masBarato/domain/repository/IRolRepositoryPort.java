package com.masBarato.masBarato.domain.repository;

import com.masBarato.masBarato.domain.model.Rol;

public interface IRolRepositoryPort {
    Rol findRolByRoleId(Integer roleId);
}
