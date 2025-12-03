package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import com.masBarato.masBarato.domain.model.Marca;
import com.masBarato.masBarato.domain.repository.IMarcaRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.MarcaEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.MarcaMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.MarcaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MarcaRepositoryAdapter implements IMarcaRepositoryPort {
    private final MarcaJpaRepository JpaRepository;

    @Override
    public Marca findMarcaByIdMarca(Integer idMarca) {
        MarcaEntity marcaEntity = JpaRepository.findMarcaEntitiesByIdMarca(idMarca);
        return MarcaMapper.fromMarcaEntityToMarca(marcaEntity);
    }
}
