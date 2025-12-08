package com.masBarato.masBarato.service.useCase.CancelledReservation;

import java.util.List;

import com.masBarato.masBarato.model.classes.CancelledReservation;

public interface ICancelledReservationFindInteractor {
    CancelledReservation findReservationByReservationId(Integer id);
    List<CancelledReservation> findReservationByUserId(String userId);
}
