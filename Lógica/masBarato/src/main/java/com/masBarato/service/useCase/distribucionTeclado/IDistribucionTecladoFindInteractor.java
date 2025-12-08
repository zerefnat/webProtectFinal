package com.masBarato.masBarato.service.useCase.distribucionTeclado;

import com.masBarato.masBarato.model.classes.DistribucionTeclado;

public interface IDistribucionTecladoFindInteractor {
    DistribucionTeclado findDistribucionTecladoById(Integer id);
}
