package com.masBarato.masBarato.useCase.reservation;

import com.masBarato.masBarato.domain.model.Reservation;
import com.masBarato.masBarato.domain.repository.IReservationRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ReservationPostInteractor implements IReservationPostInteractor{
    private final IReservationRepositoryPort reservationRepositoryPort;

    public Boolean newReservation(Reservation reservation) {
        return reservationRepositoryPort.newReservation(reservation);
    }
}