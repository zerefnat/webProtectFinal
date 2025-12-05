package com.masBarato.masBarato.useCase.distribucionTeclado;

import com.masBarato.masBarato.domain.model.DistribucionTeclado;
import com.masBarato.masBarato.domain.repository.IDistribucionTecladoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DistribucionTecladoFindInteractor implements IDistribucionTecladoFindInteractor{
    private final IDistribucionTecladoRepositoryPort tecladoRepositoryPort;

    @Override
    public DistribucionTeclado findDistribucionTecladoById(Integer id) {
        return tecladoRepositoryPort.findDistribucionTecladoById(id);
    }
}
