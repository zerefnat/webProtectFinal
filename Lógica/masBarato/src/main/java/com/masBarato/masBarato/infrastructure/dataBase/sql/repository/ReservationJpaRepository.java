package com.masBarato.masBarato.infrastructure.dataBase.sql.repository;

import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.ReservationEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, Integer> {
    ReservationEntity findReservationByReservationId(Integer reservationUserId);
    List<ReservationEntity> findReservationByUserId(Integer user); 
}

