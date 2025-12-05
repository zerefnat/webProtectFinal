package com.masBarato.masBarato.useCase.completedReservation;

import com.masBarato.masBarato.domain.model.CompletedReservation;
import com.masBarato.masBarato.domain.model.Reservation;
import java.util.List;

public interface ICompletedReservationFindInteractor {
    CompletedReservation findReservationByReservationId(Integer id);
    List<CompletedReservation> findReservationByUserId(Integer userId);
}
