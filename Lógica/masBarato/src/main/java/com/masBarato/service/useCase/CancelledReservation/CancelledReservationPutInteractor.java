package com.masBarato.masBarato.service.useCase.CancelledReservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.CancelledReservation;
import com.masBarato.masBarato.service.CancelledReservationServices;


@RequiredArgsConstructor
@Component
public class CancelledReservationPutInteractor implements ICancelledReservationPutInteractor{
    private final CancelledReservationServices cancelledReservationRService;

    @Override
    public Boolean updateCancelledReservation(Integer id, CancelledReservation reservation) {
        return cancelledReservationRService.updateCancelledReservation(id, reservation);
    }
}