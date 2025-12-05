package com.masBarato.masBarato.useCase.CompletedReservation;

import com.masBarato.masBarato.domain.model.CompletedReservation;

public interface ICompletedReservationPostInteractor {
    Boolean newCompletedReservation(CompletedReservation reservation);
}
