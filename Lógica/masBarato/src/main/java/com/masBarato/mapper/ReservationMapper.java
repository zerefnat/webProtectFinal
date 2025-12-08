package com.masBarato.masBarato.mapper;
import java.util.ArrayList;
import java.util.List;

import com.masBarato.masBarato.model.classes.Reservation;
import com.masBarato.masBarato.model.entity.LaptopEntity;
import com.masBarato.masBarato.model.entity.ReservationEntity;
import com.masBarato.masBarato.model.entity.UserEntity;

public class ReservationMapper {
public static Reservation fromEntityToDomain(ReservationEntity entity) {
if (entity == null) return null;
return new Reservation(
        entity.getReservationId(),
        entity.getMessaging(),
        entity.getMessagingPrice(),
        entity.getCreationDate(),
        entity.getPickupDate(),
        entity.getArchived(),
        entity.getUser().getUserId(),
        entity.getLaptop().getSerialNumber()
);
}

public static List<Reservation> fromEntityListToDomainList(List<ReservationEntity> entities) {
if (entities == null || entities.isEmpty()) {
return new ArrayList<>(); 
}

List<Reservation> reservations = new ArrayList<Reservation>();
for (ReservationEntity entity : entities) {
reservations.add(new Reservation(
        entity.getReservationId(),
        entity.getMessaging(),
        entity.getMessagingPrice(),
        entity.getCreationDate(),
        entity.getPickupDate(),
        entity.getArchived(),
        entity.getUser().getUserId(),
        entity.getLaptop().getSerialNumber()
));
}
return reservations;
}

public static ReservationEntity fromDomainToEntity(Reservation reservation) {
ReservationEntity entity = new ReservationEntity();
entity.setReservationId(reservation.getReservationId());
entity.setMessaging(reservation.getMessaging());
entity.setMessagingPrice(reservation.getMessagingPrice());

entity.setCreationDate(reservation.getCreationDate() == null
        ? null
        : new java.sql.Date(reservation.getCreationDate().getTime()));
entity.setPickupDate(reservation.getPickupDate() == null
        ? null
        : new java.sql.Date(reservation.getPickupDate().getTime()));
entity.setArchived(reservation.getArchived());
UserEntity user = new UserEntity();
user.setUserId(reservation.getUserId());
entity.setUser(user);

LaptopEntity laptop = new LaptopEntity();
laptop.setSerialNumber(reservation.getLaptopId());
entity.setLaptop(laptop);

return entity;
}

public static List<ReservationEntity> fromDomainListToEntityList(List<Reservation> reservations) {
if (reservations == null || reservations.isEmpty()) {
return new ArrayList<>();
}

List<ReservationEntity> entities = new ArrayList<>();
for (Reservation reservation : reservations) {
ReservationEntity entity = new ReservationEntity();
entity.setReservationId(reservation.getReservationId());
entity.setMessaging(reservation.getMessaging());
entity.setMessagingPrice(reservation.getMessagingPrice());
entity.setCreationDate(reservation.getCreationDate() == null
        ? null
        : new java.sql.Date(reservation.getCreationDate().getTime()));
entity.setPickupDate(reservation.getPickupDate() == null
        ? null
        : new java.sql.Date(reservation.getPickupDate().getTime()));
entity.setArchived(reservation.getArchived());

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
