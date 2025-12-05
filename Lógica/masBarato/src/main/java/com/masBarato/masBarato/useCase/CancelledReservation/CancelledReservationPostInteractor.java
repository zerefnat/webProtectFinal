package com.masBarato.masBarato.useCase.CancelledReservation;

import com.masBarato.masBarato.domain.model.CancelledReservation;
import com.masBarato.masBarato.domain.repository.ICancelledReservationRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CancelledReservationPostInteractor implements ICancelledReservationPostInteractor{
    private final ICancelledReservationRepositoryPort cancelledReservationRepositoryPort;

    public Boolean newCancelledReservation(CancelledReservation reservation) {
        return cancelledReservationRepositoryPort.newCancelledReservation(reservation);
    }
}