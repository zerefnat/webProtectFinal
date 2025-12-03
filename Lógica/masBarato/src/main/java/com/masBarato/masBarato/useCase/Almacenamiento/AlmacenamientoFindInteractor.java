package com.masBarato.masBarato.useCase.Almacenamiento;

import com.masBarato.masBarato.domain.model.Almacenamiento;
import com.masBarato.masBarato.domain.repository.IAlmacenamientoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AlmacenamientoFindInteractor implements IAlmacenamientoFindInteractor{
    private final IAlmacenamientoRepositoryPort almacenamientoRepositoryPort;

    @Override
    public Almacenamiento findAlmacenamientoByIdAlmacenamiento(Integer idAlmacenamiento) {
        return almacenamientoRepositoryPort.findAlmacenamientoByIdAlmacenamiento(idAlmacenamiento);
    }
}
