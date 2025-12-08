package com.masBarato.masBarato.service.useCase.Reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Reservation;
import com.masBarato.masBarato.service.ReservationServices;


@RequiredArgsConstructor
@Component
public class ReservationPostInteractor implements IReservationPostInteractor{
    private final ReservationServices reservationRepositoryPort;

    public Boolean newReservation(Reservation reservation, Integer stock) {
        return reservationRepositoryPort.newReservation(reservation, stock);
    }
}