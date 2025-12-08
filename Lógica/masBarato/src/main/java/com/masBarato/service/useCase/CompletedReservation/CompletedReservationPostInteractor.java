package com.masBarato.masBarato.service.useCase.CompletedReservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.CompletedReservation;
import com.masBarato.masBarato.service.CompletedReservationServices;


@RequiredArgsConstructor
@Component
public class CompletedReservationPostInteractor implements ICompletedReservationPostInteractor{
    private final CompletedReservationServices completedReservationService;

    public Boolean newCompletedReservation(CompletedReservation reservation) {
        return completedReservationService.newCompletedReservation(reservation);
    }
}