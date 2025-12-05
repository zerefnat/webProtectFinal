package com.masBarato.masBarato.useCase.reservation;

import com.masBarato.masBarato.domain.model.Reservation;

public interface IReservationPutInteractor {
    Boolean updateReservation(Integer id, Reservation reservation);
}
