package com.masBarato.masBarato.service.useCase.CompletedReservation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.CompletedReservation;
import com.masBarato.masBarato.service.CompletedReservationServices;

@RequiredArgsConstructor
@Component
public class CompletedReservationFindInteractor implements ICompletedReservationFindInteractor{
    private final CompletedReservationServices completedReservationServices;
    @Override
    public CompletedReservation findReservationByReservationId(Integer id){
        return completedReservationServices.findCompletedReservationByReservationId(id);
    }

    @Override
    public List<CompletedReservation> findReservationByUserId(String id) {
        return completedReservationServices.findCompletedReservationByUserId(id);
    }
}