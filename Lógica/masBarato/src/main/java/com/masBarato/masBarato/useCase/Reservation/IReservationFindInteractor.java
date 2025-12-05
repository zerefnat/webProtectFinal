package com.masBarato.masBarato.useCase.Reservation;

import com.masBarato.masBarato.domain.model.Reservation;
import java.util.List;

public interface IReservationFindInteractor {
    Reservation findReservationByReservationId(Integer id);
    List<Reservation> findReservationByUserId(Integer userId);
}
