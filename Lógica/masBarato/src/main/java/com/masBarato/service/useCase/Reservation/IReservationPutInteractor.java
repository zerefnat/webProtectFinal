package com.masBarato.masBarato.service.useCase.Reservation;

import com.masBarato.masBarato.model.classes.Reservation;

public interface IReservationPutInteractor {
    Boolean updateReservation(Integer id, Reservation reservation);
}
