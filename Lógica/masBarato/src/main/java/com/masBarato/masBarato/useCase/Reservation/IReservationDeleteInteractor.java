package com.masBarato.masBarato.useCase.Reservation;

import com.masBarato.masBarato.domain.model.Reservation;

public interface IReservationDeleteInteractor {
    Boolean deleteReservationByReservationId(Integer id);
}
