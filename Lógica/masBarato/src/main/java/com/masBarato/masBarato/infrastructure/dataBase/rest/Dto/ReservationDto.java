package com.masBarato.masBarato.infrastructure.dataBase.rest.Dto;

import com.masBarato.masBarato.domain.model.Reservation;

public record ReservationDto(
        Integer reservationId,
        Boolean messaging,
        Float messagingPrice,
        String creationDate,
        String pickupDate,
        Boolean archived,
        Integer userId,
        Integer laptopId
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