package com.masBarato.masBarato.useCase.CancelledReservation;

import com.masBarato.masBarato.domain.model.CancelledReservation;
import com.masBarato.masBarato.domain.repository.ICancelledReservationRepositoryPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CancelledReservationFindInteractor implements ICancelledReservationFindInteractor{
    private final ICancelledReservationRepositoryPort cancelledReservationRepositoryPort;
    
    @Override
    public CancelledReservation findReservationByReservationId(Integer id){
        return cancelledReservationRepositoryPort.findCanceledReservationByReservationId(id);
    }

    @Override
    public List<CancelledReservation> findReservationByUserId(Integer id) {
        return cancelledReservationRepositoryPort.findCanceledReservationByUserId(id);
    }
}