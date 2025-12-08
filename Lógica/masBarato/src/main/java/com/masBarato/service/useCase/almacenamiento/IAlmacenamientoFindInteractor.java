package com.masBarato.masBarato.service.useCase.almacenamiento;

import com.masBarato.masBarato.model.classes.Almacenamiento;

public interface IAlmacenamientoFindInteractor {
    Almacenamiento findAlmacenamientoByIdAlmacenamiento(Integer idAlmacenamiento);
}
