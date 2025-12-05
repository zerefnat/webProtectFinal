package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import com.masBarato.masBarato.domain.model.CompletedReservation;
import com.masBarato.masBarato.domain.repository.ICompletedReservationRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.CompletedReservationEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.CompletedReservationMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.CompletedReservationJpaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompletedReservationRepositoryAdapter implements ICompletedReservationRepositoryPort {
    private final CompletedReservationJpaRepository jpaRepo;

    @Override
    public CompletedReservation findCompletedReservationByReservationId(Integer id) {
        CompletedReservationEntity entity = jpaRepo.findCompletedReservationEntitiesByReservationId(id);
        return CompletedReservationMapper.fromEntityToDomain(entity);
    }

    @Override
    public List<CompletedReservation> findCompletedReservationByUserId(Integer id) {
        List<CompletedReservationEntity> entity = jpaRepo.findCompletedReservationEntitiesByUser_UserId(id);
        return CompletedReservationMapper.fromEntityListToDomainList(entity);
    }

    @Override
    public Boolean newCompletedReservation(CompletedReservation reservation) {
        CompletedReservationEntity entity = CompletedReservationMapper.fromDomainToEntity(reservation);
        jpaRepo.save(entity);
        return true;
    }
}