package com.masBarato.masBarato.useCase.reservation;

import com.masBarato.masBarato.domain.repository.IReservationRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationDeleteInteractor implements IReservationDeleteInteractor{
    private final IReservationRepositoryPort reservationRepository;

    @Override
    public Boolean deleteReservationByReservationId(Integer id) {
        return reservationRepository.deleteReservation(id);
    }
}
