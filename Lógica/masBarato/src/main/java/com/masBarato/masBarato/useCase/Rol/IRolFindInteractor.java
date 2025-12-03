package com.masBarato.masBarato.useCase.Rol;

import com.masBarato.masBarato.domain.model.Rol;

public interface IRolFindInteractor {
    Rol findRolByRoleId(Integer roleId);
}
