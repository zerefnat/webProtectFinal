package com.masBarato.masBarato.useCase.cancelledReservation;

import com.masBarato.masBarato.domain.model.CancelledReservation;
import java.util.List;

public interface ICancelledReservationFindInteractor {
    CancelledReservation findReservationByReservationId(Integer id);
    List<CancelledReservation> findReservationByUserId(Integer userId);
}
