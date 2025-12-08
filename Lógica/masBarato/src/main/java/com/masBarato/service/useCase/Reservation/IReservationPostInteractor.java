package com.masBarato.masBarato.service.useCase.Reservation;

import com.masBarato.masBarato.model.classes.Reservation;

public interface IReservationPostInteractor {
    Boolean newReservation(Reservation reservation, Integer stock);
}
