package com.masBarato.masBarato.useCase.distribucionTeclado;

import com.masBarato.masBarato.domain.model.DistribucionTeclado;

public interface IDistribucionTecladoFindInteractor {
    DistribucionTeclado findDistribucionTecladoById(Integer id);
}
