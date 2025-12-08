package com.masBarato.masBarato.service.useCase.CancelledReservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.CancelledReservation;
import com.masBarato.masBarato.service.CancelledReservationServices;


@RequiredArgsConstructor
@Component
public class CancelledReservationPostInteractor implements ICancelledReservationPostInteractor{
    private final CancelledReservationServices cancelledReservationService;

    public Boolean newCancelledReservation(CancelledReservation reservation) {
        return cancelledReservationService.newCancelledReservation(reservation);
    }
}