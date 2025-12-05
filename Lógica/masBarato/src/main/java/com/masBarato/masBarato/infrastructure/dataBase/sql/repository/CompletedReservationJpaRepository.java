package com.masBarato.masBarato.infrastructure.dataBase.sql.repository;

import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.CancelledReservationEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.CompletedReservationEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedReservationJpaRepository extends JpaRepository<CompletedReservationEntity, Integer> {
    CompletedReservationEntity findCompletedReservationEntitiesByReservationId(Integer reservationId);
    List<CompletedReservationEntity> findCompletedReservationEntitiesByUser_UserId(Integer user);
}