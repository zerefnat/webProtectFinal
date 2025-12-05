package com.masBarato.masBarato.domain.repository;

import com.masBarato.masBarato.domain.model.Marca;

public interface IMarcaRepositoryPort {
    Marca findMarcaByIdMarca(Integer idMarca);
}
