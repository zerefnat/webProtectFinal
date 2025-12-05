package com.masBarato.masBarato.useCase.rol;

import com.masBarato.masBarato.domain.model.Rol;

public interface IRolFindInteractor {
    Rol findRolByRoleId(Integer roleId);
}
