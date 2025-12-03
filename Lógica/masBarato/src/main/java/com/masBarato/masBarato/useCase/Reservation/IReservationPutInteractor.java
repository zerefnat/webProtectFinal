package com.masBarato.masBarato.useCase.Reservation;

import com.masBarato.masBarato.domain.model.Reservation;

public interface IReservationPutInteractor {
    Boolean updateReservation(Integer id, Reservation reservation);
}
