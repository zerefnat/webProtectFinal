package com.masBarato.masBarato.service.useCase.Reservation;

import java.util.List;

import com.masBarato.masBarato.model.classes.Reservation;

public interface IReservationFindInteractor {
    Reservation findReservationByReservationId(Integer id);
    List<Reservation> findReservationByUserId(String userId);
}
