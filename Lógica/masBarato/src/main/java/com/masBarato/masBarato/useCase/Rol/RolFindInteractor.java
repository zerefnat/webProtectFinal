package com.masBarato.masBarato.useCase.Rol;

import com.masBarato.masBarato.domain.model.Rol;
import com.masBarato.masBarato.domain.repository.IRolRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolFindInteractor implements IRolFindInteractor{
    private final IRolRepositoryPort irolRepositoryPort;


    @Override
    public Rol findRolByRoleId(Integer roleId) {
        return irolRepositoryPort.findRolByRoleId(roleId);
    }
}
