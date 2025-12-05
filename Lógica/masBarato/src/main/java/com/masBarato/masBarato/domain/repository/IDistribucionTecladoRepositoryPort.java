package com.masBarato.masBarato.domain.repository;

import com.masBarato.masBarato.domain.model.DistribucionTeclado;

public interface IDistribucionTecladoRepositoryPort {
    DistribucionTeclado findDistribucionTecladoById(Integer id);
}
