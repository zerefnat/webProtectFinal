package com.masBarato.masBarato.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.CompletedReservationEntity;

public interface CompletedReservationJpaRepository extends JpaRepository<CompletedReservationEntity, Integer> {
    CompletedReservationEntity findCompletedReservationEntitiesByReservationId(Integer reservationId);
    List<CompletedReservationEntity> findCompletedReservationEntitiesByUser_UserId(String user);

}