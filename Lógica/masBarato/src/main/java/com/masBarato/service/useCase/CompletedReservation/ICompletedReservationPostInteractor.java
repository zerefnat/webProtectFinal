package com.masBarato.masBarato.service.useCase.CompletedReservation;

import com.masBarato.masBarato.model.classes.CompletedReservation;

public interface ICompletedReservationPostInteractor {
    Boolean newCompletedReservation(CompletedReservation reservation);
}
