package com.masBarato.masBarato.mapper;

import java.util.ArrayList;
import java.util.List;

import com.masBarato.masBarato.model.classes.CompletedReservation;
import com.masBarato.masBarato.model.entity.CompletedReservationEntity;
import com.masBarato.masBarato.model.entity.LaptopEntity;
import com.masBarato.masBarato.model.entity.UserEntity;

public class CompletedReservationMapper {
    public static CompletedReservation fromEntityToDomain(CompletedReservationEntity entity) {
        if (entity == null) return null;
        return new CompletedReservation(
            entity.getReservationId(),
            entity.getMessaging(),
            entity.getMessagingPrice(),
            entity.getCreationDate(),
            entity.getPickupDate(),
            entity.getUser().getUserId(),
            entity.getLaptop().getSerialNumber()
        );
    }

    public static List<CompletedReservation> fromEntityListToDomainList(List<CompletedReservationEntity> entities) {
if (entities == null || entities.isEmpty()) {
return new ArrayList<>(); 
}

List<CompletedReservation> reservations = new ArrayList<CompletedReservation>();
for (CompletedReservationEntity entity : entities) {
reservations.add(new CompletedReservation(
        entity.getReservationId(),
        entity.getMessaging(),
        entity.getMessagingPrice(),
        entity.getCreationDate(),
        entity.getPickupDate(),
        entity.getUser().getUserId(),
        entity.getLaptop().getSerialNumber()
));
}
return reservations;
}

    public static CompletedReservationEntity fromDomainToEntity(CompletedReservation reservation) {
        CompletedReservationEntity entity = new CompletedReservationEntity();
        entity.setReservationId(reservation.getReservationId());
        entity.setMessaging(reservation.getMessaging());
        entity.setMessagingPrice(reservation.getMessagingPrice());
        entity.setCreationDate(reservation.getCreationDate() == null
                ? null
                : new java.sql.Date(reservation.getCreationDate().getTime()));
        entity.setPickupDate(reservation.getPickupDate() == null
                ? null
                : new java.sql.Date(reservation.getPickupDate().getTime()));

        UserEntity user = new UserEntity();
        user.setUserId(reservation.getUserId());
        entity.setUser(user);

        LaptopEntity laptop = new LaptopEntity();
        laptop.setSerialNumber(reservation.getLaptopId());
        entity.setLaptop(laptop);

        return entity;
    }

    public static List<CompletedReservationEntity> fromDomainListToEntityList(List<CompletedReservation> reservations) {
if (reservations == null || reservations.isEmpty()) {
return new ArrayList<>();
}

List<CompletedReservationEntity> entities = new ArrayList<>();
for (CompletedReservation reservation : reservations) {
CompletedReservationEntity entity = new CompletedReservationEntity();
entity.setReservationId(reservation.getReservationId());
entity.setMessaging(reservation.getMessaging());
entity.setMessagingPrice(reservation.getMessagingPrice());
entity.setCreationDate(reservation.getCreationDate() == null
            ? null
            : new java.sql.Date(reservation.getCreationDate().getTime()));
entity.setPickupDate(reservation.getPickupDate() == null
            ? null
            : new java.sql.Date(reservation.getPickupDate().getTime()));
UserEntity user = new UserEntity();
user.setUserId(reservation.getUserId());
entity.setUser(user);

LaptopEntity laptop = new LaptopEntity();
laptop.setSerialNumber(reservation.getLaptopId());
entity.setLaptop(laptop);

entities.add(entity);
}
return entities;
}
}