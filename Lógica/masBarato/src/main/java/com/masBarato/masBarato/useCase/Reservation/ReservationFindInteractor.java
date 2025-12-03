package com.masBarato.masBarato.useCase.Reservation;

import com.masBarato.masBarato.domain.model.Reservation;
import com.masBarato.masBarato.domain.repository.IReservationRepositoryPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReservationFindInteractor implements IReservationFindInteractor{
    private final IReservationRepositoryPort reservationRepositoryPort;
    @Override
    public Reservation findReservationByReservationId(Integer id){
        return reservationRepositoryPort.findReservationByReservationId(id);
    }

    @Override
    public List<Reservation> findReservationByUserId(Integer id) {
        return reservationRepositoryPort.findReservationByUserId(id);
    }
}