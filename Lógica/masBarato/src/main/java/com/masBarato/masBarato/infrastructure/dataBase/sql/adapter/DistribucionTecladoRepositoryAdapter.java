package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import com.masBarato.masBarato.domain.model.DistribucionTeclado;
import com.masBarato.masBarato.domain.repository.IDistribucionTecladoRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.DistribucionTecladoEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.DistribucionTecladoMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.DistribucionTecladoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DistribucionTecladoRepositoryAdapter implements IDistribucionTecladoRepositoryPort {
    private final DistribucionTecladoJpaRepository jpaRepository;

    @Override
    public DistribucionTeclado findDistribucionTecladoById(Integer id) {
        DistribucionTecladoEntity dt = jpaRepository.findDistribucionTecladoEntitiesById(id);
        return DistribucionTecladoMapper.fromDTEntityToDt(dt);
    }
}
