package com.masBarato.masBarato.service.useCase.CancelledReservation;

import com.masBarato.masBarato.model.classes.CancelledReservation;

public interface ICancelledReservationPutInteractor {
    Boolean updateCancelledReservation(Integer id, CancelledReservation reservation);
}
