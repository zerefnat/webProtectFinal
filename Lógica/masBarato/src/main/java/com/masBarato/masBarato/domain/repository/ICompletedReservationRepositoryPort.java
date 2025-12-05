
package com.masBarato.masBarato.domain.repository;

import com.masBarato.masBarato.domain.model.CompletedReservation;
import java.util.List;

public interface ICompletedReservationRepositoryPort {
    CompletedReservation findCompletedReservationByReservationId(Integer id);
    List<CompletedReservation> findCompletedReservationByUserId(Integer reservationUserId);
    Boolean newCompletedReservation(CompletedReservation reservation);

}