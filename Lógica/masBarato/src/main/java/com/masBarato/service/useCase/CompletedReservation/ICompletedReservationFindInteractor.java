package com.masBarato.masBarato.service.useCase.CompletedReservation;

import java.util.List;

import com.masBarato.masBarato.model.classes.CompletedReservation;

public interface ICompletedReservationFindInteractor {
    CompletedReservation findReservationByReservationId(Integer id);
    List<CompletedReservation> findReservationByUserId(String userId);
}
