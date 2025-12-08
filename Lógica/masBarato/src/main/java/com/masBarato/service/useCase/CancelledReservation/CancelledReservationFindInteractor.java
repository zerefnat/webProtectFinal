package com.masBarato.masBarato.service.useCase.CancelledReservation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.CancelledReservation;
import com.masBarato.masBarato.service.CancelledReservationServices;

@RequiredArgsConstructor
@Component
public class CancelledReservationFindInteractor implements ICancelledReservationFindInteractor{
    private final CancelledReservationServices cancelledReservationService;
    
    @Override
    public CancelledReservation findReservationByReservationId(Integer id){
        return cancelledReservationService.findCanceledReservationByReservationId(id);
    }

    @Override
    public List<CancelledReservation> findReservationByUserId(String id) {
        return cancelledReservationService.findCanceledReservationByUserId(id);
    }
}