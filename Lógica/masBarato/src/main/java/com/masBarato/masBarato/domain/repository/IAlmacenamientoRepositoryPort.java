package com.masBarato.masBarato.domain.repository;

import com.masBarato.masBarato.domain.model.Almacenamiento;

public interface IAlmacenamientoRepositoryPort {
    Almacenamiento findAlmacenamientoByIdAlmacenamiento(Integer idAlmacenamiento);
}
