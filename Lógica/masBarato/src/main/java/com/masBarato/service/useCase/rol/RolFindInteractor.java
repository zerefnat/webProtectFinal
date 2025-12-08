package com.masBarato.masBarato.service.useCase.rol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Rol;
import com.masBarato.masBarato.service.RolServices;

@Component
@RequiredArgsConstructor
public class RolFindInteractor implements IRolFindInteractor{
    private final RolServices irolRepositoryPort;


    @Override
    public Rol findRolByRoleId(Integer roleId) {
        return irolRepositoryPort.findRolByRoleId(roleId);
    }
}
