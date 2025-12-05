package com.masBarato.masBarato.infrastructure.dataBase.sql.mapper;

import com.masBarato.masBarato.domain.model.CancelledReservation;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.CancelledReservationEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.LaptopEntity;
import java.util.ArrayList;
import java.util.List;

public class CancelledReservationMapper {
    public static CancelledReservation fromEntityToDomain(CancelledReservationEntity entity) {
        if (entity == null) return null;
        return new CancelledReservation(
                entity.getReservationId(),
                entity.getMessaging(),
                entity.getMessagingPrice(),
                entity.getCreationDate(),
                entity.getUser().getUserId(),
                entity.getLaptop().getIdLaptop()
        );
    }

    public static List<CancelledReservation> fromEntityListToDomainList(List<CancelledReservationEntity> entities) {
if (entities == null || entities.isEmpty()) {
return new ArrayList<>(); 
}

List<CancelledReservation> reservations = new ArrayList<CancelledReservation>();
for (CancelledReservationEntity entity : entities) {
reservations.add(new CancelledReservation(
        entity.getReservationId(),
        entity.getMessaging(),
        entity.getMessagingPrice(),
        entity.getCreationDate(),
        entity.getUser().getUserId(),
        entity.getLaptop().getIdLaptop()
));
}
return reservations;
}

    public static CancelledReservationEntity fromDomainToEntity(CancelledReservation reservation) {
        CancelledReservationEntity entity = new CancelledReservationEntity();
        entity.setReservationId(reservation.getReservationId());
        entity.setMessaging(reservation.getMessaging());
        entity.setMessagingPrice(reservation.getMessagingPrice());
        entity.setCreationDate(reservation.getCreationDate() == null
                ? null
                : new java.sql.Date(reservation.getCreationDate().getTime()));
        UserEntity user = new UserEntity();
        user.setUserId(reservation.getUserId());
        entity.setUser(user);

        LaptopEntity laptop = new LaptopEntity();
        laptop.setIdLaptop(reservation.getLaptopId());
        entity.setLaptop(laptop);

        return entity;
    }
    
public static List<CancelledReservationEntity> fromDomainListToEntityList(List<CancelledReservation> reservations) {
if (reservations == null || reservations.isEmpty()) {
return new ArrayList<>();
}

List<CancelledReservationEntity> entities = new ArrayList<>();
for (CancelledReservation reservation : reservations) {
CancelledReservationEntity entity = new CancelledReservationEntity();
entity.setReservationId(reservation.getReservationId());
entity.setMessaging(reservation.getMessaging());
entity.setMessagingPrice(reservation.getMessagingPrice());
    entity.setCreationDate(reservation.getCreationDate() == null
            ? null
            : new java.sql.Date(reservation.getCreationDate().getTime()));

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
