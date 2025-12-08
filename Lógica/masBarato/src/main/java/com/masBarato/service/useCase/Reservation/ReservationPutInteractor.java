package com.masBarato.masBarato.service.useCase.Reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Reservation;
import com.masBarato.masBarato.service.ReservationServices;


@RequiredArgsConstructor
@Component
public class ReservationPutInteractor implements IReservationPutInteractor{
    private final ReservationServices reservationRepositoryPort;

    @Override
    public Boolean updateReservation(Integer id, Reservation reservation) {
        return reservationRepositoryPort.updateReservation(id, reservation);
    }
}