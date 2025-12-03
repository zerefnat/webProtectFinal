package com.masBarato.masBarato.useCase.Almacenamiento;

import com.masBarato.masBarato.domain.model.Almacenamiento;

public interface IAlmacenamientoFindInteractor {
    Almacenamiento findAlmacenamientoByIdAlmacenamiento(Integer idAlmacenamiento);
}
