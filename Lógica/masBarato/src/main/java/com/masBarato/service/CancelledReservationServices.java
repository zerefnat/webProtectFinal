package com.masBarato.masBarato.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.CancelledReservationMapper;
import com.masBarato.masBarato.model.classes.CancelledReservation;
import com.masBarato.masBarato.model.entity.CancelledReservationEntity;
import com.masBarato.masBarato.repository.CancelledReservationJpaRepository;

@Component
@RequiredArgsConstructor
public class CancelledReservationServices {
    private final CancelledReservationJpaRepository jpaRepo;

    public CancelledReservation findCanceledReservationByReservationId(Integer id) {
        CancelledReservationEntity entity = jpaRepo.findCancelledReservationEntitiesByReservationId(id);
        return CancelledReservationMapper.fromEntityToDomain(entity);
    }

    public List<CancelledReservation> findCanceledReservationByUserId(String id) {
        List<CancelledReservationEntity> entity = jpaRepo.findCancelledReservationEntitiesByUser_UserId(id);
        return CancelledReservationMapper.fromEntityListToDomainList(entity);
    }

    public Boolean newCancelledReservation(CancelledReservation reservation) {
        CancelledReservationEntity entity = CancelledReservationMapper.fromDomainToEntity(reservation);
        jpaRepo.save(entity);
        return true;
    }

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