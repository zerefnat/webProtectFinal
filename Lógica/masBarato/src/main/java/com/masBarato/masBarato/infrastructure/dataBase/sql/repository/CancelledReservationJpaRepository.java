package com.masBarato.masBarato.infrastructure.dataBase.sql.repository;

import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.CancelledReservationEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelledReservationJpaRepository extends JpaRepository<CancelledReservationEntity, Integer> {
    CancelledReservationEntity findByReservationId(Integer reservationId);
    List<CancelledReservationEntity> findReservationByUserId(Integer user); 
}