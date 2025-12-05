package com.masBarato.masBarato.useCase.completedReservation;

import com.masBarato.masBarato.domain.model.CompletedReservation;
import com.masBarato.masBarato.domain.repository.ICompletedReservationRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CompletedReservationPostInteractor implements ICompletedReservationPostInteractor{
    private final ICompletedReservationRepositoryPort completedReservationRepositoryPort;

    public Boolean newCompletedReservation(CompletedReservation reservation) {
        return completedReservationRepositoryPort.newCompletedReservation(reservation);
    }
}