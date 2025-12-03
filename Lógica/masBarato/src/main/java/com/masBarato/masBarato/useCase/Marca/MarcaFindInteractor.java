package com.masBarato.masBarato.useCase.Marca;

import com.masBarato.masBarato.domain.model.Marca;
import com.masBarato.masBarato.domain.repository.IMarcaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MarcaFindInteractor implements IMarcaFindInteractor {
    private final IMarcaRepositoryPort marcaRepositoryPort;

    @Override
    public Marca findMarcaByIdMarca(Integer idMarca) {
        return marcaRepositoryPort.findMarcaByIdMarca(idMarca);
    }
}
