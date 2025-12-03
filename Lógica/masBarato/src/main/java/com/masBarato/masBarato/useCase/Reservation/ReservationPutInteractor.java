package com.masBarato.masBarato.useCase.Reservation;

import com.masBarato.masBarato.domain.model.Reservation;
import com.masBarato.masBarato.domain.repository.IReservationRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ReservationPutInteractor implements IReservationPutInteractor{
    private final IReservationRepositoryPort reservationRepositoryPort;

    @Override
    public Boolean updateReservation(Integer id, Reservation reservation) {
        return reservationRepositoryPort.updateReservation(id, reservation);
    }
}