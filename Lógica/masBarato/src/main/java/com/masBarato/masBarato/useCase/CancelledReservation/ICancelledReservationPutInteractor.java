package com.masBarato.masBarato.useCase.CancelledReservation;

import com.masBarato.masBarato.domain.model.CancelledReservation;
import com.masBarato.masBarato.domain.model.Reservation;

public interface ICancelledReservationPutInteractor {
    Boolean updateCancelledReservation(Integer id, CancelledReservation reservation);
}
