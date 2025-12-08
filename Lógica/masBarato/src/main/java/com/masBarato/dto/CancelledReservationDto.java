
package com.masBarato.masBarato.dto;

import java.util.Date;

import com.masBarato.masBarato.model.classes.CancelledReservation;

public record CancelledReservationDto(
        Integer reservationId,
        Boolean messaging,
        Float messagingPrice,
        Date creationDate,
        String userId,
        String laptopId
) {
    public static CancelledReservationDto fromDomain(CancelledReservation reservation) {
        if (reservation == null) return null;
        return new CancelledReservationDto(
                reservation.getReservationId(),
                reservation.getMessaging(),
                reservation.getMessagingPrice(),
                reservation.getCreationDate(),
                reservation.getUserId(),
                reservation.getLaptopId()
        );
    }

    public static CancelledReservation toDomain(CancelledReservationDto dto) {
        if (dto == null) return null;
        return new CancelledReservation(
                dto.reservationId(),
                dto.messaging(),
                dto.messagingPrice(),
                dto.creationDate(),
                dto.userId(),
                dto.laptopId()
        );
    }
}
