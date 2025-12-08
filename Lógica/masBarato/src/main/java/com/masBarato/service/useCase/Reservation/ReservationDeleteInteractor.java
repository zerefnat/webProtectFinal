package com.masBarato.masBarato.service.useCase.Reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.service.ReservationServices;

@Component
@RequiredArgsConstructor
public class ReservationDeleteInteractor implements IReservationDeleteInteractor{
    private final ReservationServices reservationRepository;

    @Override
    public Boolean deleteReservationByReservationId(Integer id) {
        return reservationRepository.deleteReservation(id);
    }
}
