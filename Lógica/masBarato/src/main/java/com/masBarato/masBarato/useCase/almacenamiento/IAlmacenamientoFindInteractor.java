package com.masBarato.masBarato.useCase.almacenamiento;

import com.masBarato.masBarato.domain.model.Almacenamiento;

public interface IAlmacenamientoFindInteractor {
    Almacenamiento findAlmacenamientoByIdAlmacenamiento(Integer idAlmacenamiento);
}
