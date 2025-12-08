package com.masBarato.masBarato.dto;

import java.util.Date;

import com.masBarato.masBarato.model.classes.Reservation;

public record ReservationDto(
        Integer reservationId,
        Boolean messaging,
        Float messagingPrice,
        Date creationDate,
        Date pickupDate,
        Boolean archived,
        String userId,
        String laptopId
) {
    public static ReservationDto fromDomain(Reservation reservation) {
        if (reservation == null) return null;
        return new ReservationDto(
                reservation.getReservationId(),
                reservation.getMessaging(),
                reservation.getMessagingPrice(),
                reservation.getCreationDate(),
                reservation.getPickupDate(),
                reservation.getArchived(),
                reservation.getUserId(),
                reservation.getLaptopId()
        );
    }

    public static Reservation toDomain(ReservationDto dto) {
        if (dto == null) return null;
        return new Reservation(
                dto.reservationId(),
                dto.messaging(),
                dto.messagingPrice(),
                dto.creationDate(),
                dto.pickupDate(),
                dto.archived(),
                dto.userId(),
                dto.laptopId()
        );
    }

}