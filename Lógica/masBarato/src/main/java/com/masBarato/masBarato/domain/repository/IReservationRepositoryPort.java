package com.masBarato.masBarato.domain.repository;

import com.masBarato.masBarato.domain.model.Reservation;
import java.util.List;

public interface IReservationRepositoryPort {
    Reservation findReservationByReservationId(Integer reservationUserId);
    List<Reservation> findReservationByUserId(Integer reservationUserId);
    Boolean deleteReservation(Integer reservationId);
    Boolean newReservation(Reservation reservation);
    Boolean finishReservation(Integer reservationId);
    Boolean updateReservation(Integer reservationId,Reservation reservation);
}
 