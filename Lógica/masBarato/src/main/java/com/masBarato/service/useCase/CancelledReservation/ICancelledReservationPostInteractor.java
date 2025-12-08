package com.masBarato.masBarato.service.useCase.CancelledReservation;

import com.masBarato.masBarato.model.classes.CancelledReservation;

public interface ICancelledReservationPostInteractor {
    Boolean newCancelledReservation(CancelledReservation reservation);
}
