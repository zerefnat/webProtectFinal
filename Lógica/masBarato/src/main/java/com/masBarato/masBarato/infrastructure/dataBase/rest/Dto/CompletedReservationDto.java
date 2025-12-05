
package com.masBarato.masBarato.infrastructure.dataBase.rest.Dto;

import com.masBarato.masBarato.domain.model.CompletedReservation;

import java.util.Date;

public record CompletedReservationDto(
        Integer reservationId,
        Boolean messaging,
        Float messagingPrice,
        Date creationDate,
        Date pickupDate,
        Integer userId,
        Integer laptopId
) {
    public static CompletedReservationDto fromDomain(CompletedReservation reservation) {
        if (reservation == null) return null;
        return new CompletedReservationDto(
                reservation.getReservationId(),
                reservation.getMessaging(),
                reservation.getMessagingPrice(),
                reservation.getCreationDate(),
                reservation.getPickupDate(),
                reservation.getUserId(),
                reservation.getLaptopId()
        );
    }

    public static CompletedReservation toDomain(CompletedReservationDto dto) {
        if (dto == null) return null;
        return new CompletedReservation(
                dto.reservationId(),
                dto.messaging(),
                dto.messagingPrice(),
                dto.creationDate(),
                dto.pickupDate(),
                dto.userId(),
                dto.laptopId()
        );
    }
}

