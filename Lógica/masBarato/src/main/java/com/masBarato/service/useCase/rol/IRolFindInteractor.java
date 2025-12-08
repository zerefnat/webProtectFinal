package com.masBarato.masBarato.service.useCase.rol;

import com.masBarato.masBarato.model.classes.Rol;

public interface IRolFindInteractor {
    Rol findRolByRoleId(Integer roleId);
}
