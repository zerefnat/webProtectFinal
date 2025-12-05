package com.masBarato.masBarato.useCase.cancelledReservation;

import com.masBarato.masBarato.domain.model.CancelledReservation;
import com.masBarato.masBarato.domain.repository.ICancelledReservationRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CancelledReservationPutInteractor implements ICancelledReservationPutInteractor{
    private final ICancelledReservationRepositoryPort cancelledReservationRepositoryPort;

    @Override
    public Boolean updateCancelledReservation(Integer id, CancelledReservation reservation) {
        return cancelledReservationRepositoryPort.updateCancelledReservation(id, reservation);
    }
}