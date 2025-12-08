package com.masBarato.masBarato.service.useCase.Reservation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Reservation;
import com.masBarato.masBarato.service.ReservationServices;

@RequiredArgsConstructor
@Component
public class ReservationFindInteractor implements IReservationFindInteractor{
    private final ReservationServices reservationRepositoryPort;
    @Override
    public Reservation findReservationByReservationId(Integer id){
        return reservationRepositoryPort.findReservationByReservationId(id);
    }

    @Override
    public List<Reservation> findReservationByUserId(String id) {
        return reservationRepositoryPort.findReservationByUserId(id);
    }
}