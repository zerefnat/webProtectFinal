package com.masBarato.masBarato.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.CancelledReservationEntity;

public interface CancelledReservationJpaRepository extends JpaRepository<CancelledReservationEntity, Integer> {
    CancelledReservationEntity findCancelledReservationEntitiesByReservationId(Integer reservationId);
    List<CancelledReservationEntity> findCancelledReservationEntitiesByUser_UserId(String user);

}