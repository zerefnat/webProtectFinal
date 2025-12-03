package com.masBarato.masBarato.infrastructure.dataBase.rest.Dto;

import com.masBarato.masBarato.domain.model.CancelledReservation;

public record CancelledReservationDto(
        Integer reservationId,
        Boolean messaging,
        Float messagingPrice,
        String creationDate,
        Integer userId,
        Integer laptopId
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
