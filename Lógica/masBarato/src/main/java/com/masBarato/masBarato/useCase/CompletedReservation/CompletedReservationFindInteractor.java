package com.masBarato.masBarato.useCase.CompletedReservation;

import com.masBarato.masBarato.domain.model.CompletedReservation;
import com.masBarato.masBarato.domain.repository.ICompletedReservationRepositoryPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CompletedReservationFindInteractor implements ICompletedReservationFindInteractor{
    private final ICompletedReservationRepositoryPort completedReservationRepositoryPort;
    @Override
    public CompletedReservation findReservationByReservationId(Integer id){
        return completedReservationRepositoryPort.findCompletedReservationByReservationId(id);
    }

    @Override
    public List<CompletedReservation> findReservationByUserId(Integer id) {
        return completedReservationRepositoryPort.findCompletedReservationByUserId(id);
    }
}