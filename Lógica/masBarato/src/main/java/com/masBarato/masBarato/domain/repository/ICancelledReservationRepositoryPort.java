
package com.masBarato.masBarato.domain.repository;

import com.masBarato.masBarato.domain.model.CancelledReservation;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ICancelledReservationRepositoryPort {
    CancelledReservation findCanceledReservationByReservationId(Integer reservationUserId);
    List<CancelledReservation> findCanceledReservationByUserId(Integer reservationUserId);
    Boolean newCancelledReservation(CancelledReservation reservation);
    Boolean updateCancelledReservation(Integer id, CancelledReservation reservation);

}