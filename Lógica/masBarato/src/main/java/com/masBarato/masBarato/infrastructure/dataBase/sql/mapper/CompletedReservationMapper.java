
package com.masBarato.masBarato.infrastructure.dataBase.sql.mapper;

import com.masBarato.masBarato.domain.model.CompletedReservation;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.CompletedReservationEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.LaptopEntity;
import java.util.ArrayList;
import java.util.List;

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
            entity.getLaptop().getIdLaptop()
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
        entity.getLaptop().getIdLaptop()
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
        laptop.setIdLaptop(reservation.getLaptopId());
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
laptop.setIdLaptop(reservation.getLaptopId());
entity.setLaptop(laptop);

entities.add(entity);
}
return entities;
}
}