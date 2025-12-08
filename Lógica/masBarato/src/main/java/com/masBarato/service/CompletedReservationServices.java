package com.masBarato.masBarato.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.CompletedReservationMapper;
import com.masBarato.masBarato.model.classes.CompletedReservation;
import com.masBarato.masBarato.model.entity.CompletedReservationEntity;
import com.masBarato.masBarato.repository.CompletedReservationJpaRepository;

@Component
@RequiredArgsConstructor
public class CompletedReservationServices {
    private final CompletedReservationJpaRepository jpaRepo;

    public CompletedReservation findCompletedReservationByReservationId(Integer id) {
        CompletedReservationEntity entity = jpaRepo.findCompletedReservationEntitiesByReservationId(id);
        return CompletedReservationMapper.fromEntityToDomain(entity);
    }

    public List<CompletedReservation> findCompletedReservationByUserId(String id) {
        List<CompletedReservationEntity> entity = jpaRepo.findCompletedReservationEntitiesByUser_UserId(id);
        return CompletedReservationMapper.fromEntityListToDomainList(entity);
    }

    public Boolean newCompletedReservation(CompletedReservation reservation) {
        CompletedReservationEntity entity = CompletedReservationMapper.fromDomainToEntity(reservation);
        jpaRepo.save(entity);
        return true;
    }

}