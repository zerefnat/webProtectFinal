package com.masBarato.masBarato.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.ReservationEntity;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, Integer> {
    ReservationEntity findReservationEntityByReservationId(Integer reservationUserId);
    List<ReservationEntity> findReservationEntityByUser_UserId(String user);
}