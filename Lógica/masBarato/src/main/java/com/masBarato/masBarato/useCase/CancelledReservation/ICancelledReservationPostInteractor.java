package com.masBarato.masBarato.useCase.CancelledReservation;

import com.masBarato.masBarato.domain.model.CancelledReservation;

public interface ICancelledReservationPostInteractor {
    Boolean newCancelledReservation(CancelledReservation reservation);
}
