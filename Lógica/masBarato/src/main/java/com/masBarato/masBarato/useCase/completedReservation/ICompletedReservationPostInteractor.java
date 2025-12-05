package com.masBarato.masBarato.useCase.completedReservation;

import com.masBarato.masBarato.domain.model.CompletedReservation;

public interface ICompletedReservationPostInteractor {
    Boolean newCompletedReservation(CompletedReservation reservation);
}
