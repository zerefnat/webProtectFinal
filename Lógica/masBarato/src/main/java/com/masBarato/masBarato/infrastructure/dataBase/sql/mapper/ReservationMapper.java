package com.masBarato.masBarato.infrastructure.dataBase.sql.mapper;

import com.masBarato.masBarato.domain.model.Reservation;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.ReservationEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.UserEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.LaptopEntity;
import java.util.ArrayList;
import java.util.List;

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
        entity.getLaptop().getIdLaptop()
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
        entity.getLaptop().getIdLaptop()
));
}
return reservations;
}

public static ReservationEntity fromDomainToEntity(Reservation reservation) {
ReservationEntity entity = new ReservationEntity();
entity.setReservationId(reservation.getReservationId());
entity.setMessaging(reservation.getMessaging());
entity.setMessagingPrice(reservation.getMessagingPrice());
entity.setCreationDate(reservation.getCreationDate());
entity.setPickupDate(reservation.getPickupDate());
entity.setArchived(reservation.getArchived());

UserEntity user = new UserEntity();
user.setUserId(reservation.getUserId());
entity.setUser(user);

LaptopEntity laptop = new LaptopEntity();
laptop.setIdLaptop(reservation.getLaptopId());
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
entity.setCreationDate(reservation.getCreationDate());
entity.setPickupDate(reservation.getPickupDate());
entity.setArchived(reservation.getArchived());

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
