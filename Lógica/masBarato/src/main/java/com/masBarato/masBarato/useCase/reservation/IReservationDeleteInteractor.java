package com.masBarato.masBarato.useCase.reservation;

import com.masBarato.masBarato.domain.model.Reservation;

public interface IReservationDeleteInteractor {
    Boolean deleteReservationByReservationId(Integer id);
}
