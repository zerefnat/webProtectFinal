package com.masBarato.masBarato.service.useCase.marca;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Marca;
import com.masBarato.masBarato.service.MarcaServices;

@RequiredArgsConstructor
@Component
public class MarcaFindInteractor implements IMarcaFindInteractor {
    private final MarcaServices marcaRepositoryPort;

    @Override
    public Marca findMarcaByIdMarca(Integer idMarca) {
        return marcaRepositoryPort.findMarcaByIdMarca(idMarca);
    }
}
