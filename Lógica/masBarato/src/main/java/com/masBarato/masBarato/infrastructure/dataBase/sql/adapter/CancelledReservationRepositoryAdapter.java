
package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import com.masBarato.masBarato.domain.model.CancelledReservation;
import com.masBarato.masBarato.domain.repository.ICancelledReservationRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.CancelledReservationEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.CancelledReservationMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.CancelledReservationJpaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CancelledReservationRepositoryAdapter implements ICancelledReservationRepositoryPort {
    private final CancelledReservationJpaRepository jpaRepo;

    @Override
    public CancelledReservation findCanceledReservationByReservationId(Integer id) {
        CancelledReservationEntity entity = jpaRepo.findCancelledReservationEntitiesByReservationId(id);
        return CancelledReservationMapper.fromEntityToDomain(entity);
    }

     @Override
    public List<CancelledReservation> findCanceledReservationByUserId(Integer id) {
        List<CancelledReservationEntity> entity = jpaRepo.findCancelledReservationEntitiesByUser_UserId(id);
        return CancelledReservationMapper.fromEntityListToDomainList(entity);
    }

    @Override
    public Boolean newCancelledReservation(CancelledReservation reservation) {
        CancelledReservationEntity entity = CancelledReservationMapper.fromDomainToEntity(reservation);
        jpaRepo.save(entity);
        return true;
    }

    @Override
    public Boolean updateCancelledReservation(Integer id, CancelledReservation reservation) {
        Optional<CancelledReservationEntity> optionalCancelledReservationEntity = Optional.ofNullable(jpaRepo.findCancelledReservationEntitiesByReservationId(id));
        if(optionalCancelledReservationEntity.isEmpty()) {
            return false;
        }
        CancelledReservationEntity updateCancelledReservationEntity = CancelledReservationMapper.fromDomainToEntity(reservation);
        updateCancelledReservationEntity.setReservationId(id);
        jpaRepo.save(updateCancelledReservationEntity);
        return true;
    }
}