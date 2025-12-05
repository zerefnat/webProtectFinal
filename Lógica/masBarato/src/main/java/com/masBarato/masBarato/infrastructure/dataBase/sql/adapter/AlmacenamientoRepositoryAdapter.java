package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import com.masBarato.masBarato.domain.model.Almacenamiento;
import com.masBarato.masBarato.domain.repository.IAlmacenamientoRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.AlmacenamientoEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.AlmacenamientoMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.AlmacenamientoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AlmacenamientoRepositoryAdapter implements IAlmacenamientoRepositoryPort {
    private final AlmacenamientoJpaRepository jpaRepository;

    @Override
    public Almacenamiento findAlmacenamientoByIdAlmacenamiento(Integer idAlmacenamiento) {
        AlmacenamientoEntity almacenamientoEntity = jpaRepository.findAlmacenamientoEntityByIdAlmacenamiento(idAlmacenamiento);
        return AlmacenamientoMapper.fromAlmacenamientoEntityToAlmacenamiento(almacenamientoEntity);
    }
}
