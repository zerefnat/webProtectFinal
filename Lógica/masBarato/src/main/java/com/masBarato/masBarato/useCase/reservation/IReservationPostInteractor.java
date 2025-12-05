package com.masBarato.masBarato.useCase.reservation;

import com.masBarato.masBarato.domain.model.Reservation;

public interface IReservationPostInteractor {
    Boolean newReservation(Reservation reservation);
}
