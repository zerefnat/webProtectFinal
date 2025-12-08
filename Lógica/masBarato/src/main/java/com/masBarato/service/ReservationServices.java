
package com.masBarato.masBarato.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.ReservationMapper;
import com.masBarato.masBarato.model.classes.Reservation;
import com.masBarato.masBarato.model.entity.CancelledReservationEntity;
import com.masBarato.masBarato.model.entity.CompletedReservationEntity;
import com.masBarato.masBarato.model.entity.ReservationEntity;
import com.masBarato.masBarato.model.entity.StockEntity;
import com.masBarato.masBarato.repository.CancelledReservationJpaRepository;
import com.masBarato.masBarato.repository.CompletedReservationJpaRepository;
import com.masBarato.masBarato.repository.ReservationJpaRepository;
import com.masBarato.masBarato.repository.StockJpaRepository;

@Component
@RequiredArgsConstructor
public class ReservationServices{
    private final ReservationJpaRepository jpaRepo;
    private final CancelledReservationJpaRepository jpaCancelledRepo;
    private final CompletedReservationJpaRepository jpaCompletedRepo;
    private final StockJpaRepository stockJpaRepository;
    
    public Reservation findReservationByReservationId(Integer id) {
        ReservationEntity entity = jpaRepo.findReservationEntityByReservationId(id);
        return ReservationMapper.fromEntityToDomain(entity);
    }

    public List<Reservation> findReservationByUserId(String id) {
        List<ReservationEntity> entity = jpaRepo.findReservationEntityByUser_UserId(id);
        return ReservationMapper.fromEntityListToDomainList(entity);
    }

    public Boolean newReservation(Reservation reservation, Integer stockId) {
        StockEntity stock = stockJpaRepository.findStockEntityByStockId(stockId);
        stock.setQuantity(stock.getQuantity()-1);
        stockJpaRepository.save(stock);

        ReservationEntity entity = ReservationMapper.fromDomainToEntity(reservation);
        jpaRepo.save(entity);
        return findReservationByReservationId(entity.getReservationId()) == null;
    }

    public Boolean updateReservation(Integer id, Reservation reservation) {
        Optional<ReservationEntity> optionalReservationEntity = Optional.ofNullable(jpaRepo.findReservationEntityByReservationId(id));
        if(optionalReservationEntity.isEmpty()) {
            return false;
        }
        ReservationEntity updateReservationEntity = ReservationMapper.fromDomainToEntity(reservation);
        updateReservationEntity.setReservationId(id);
        jpaRepo.save(updateReservationEntity);
        return true;
    }

public Boolean deleteReservation(Integer id) {
    Optional<ReservationEntity> optionalReservation = jpaRepo.findById(id);
    if (optionalReservation.isPresent()) {
        ReservationEntity reservation = optionalReservation.get();

        CancelledReservationEntity cancelled = new CancelledReservationEntity();
        cancelled.setReservationId(reservation.getReservationId());
        cancelled.setMessaging(reservation.getMessaging());
        cancelled.setMessagingPrice(reservation.getMessagingPrice());
        cancelled.setCreationDate(reservation.getCreationDate());
        cancelled.setUser(reservation.getUser());
        cancelled.setLaptop(reservation.getLaptop());
        jpaCancelledRepo.save(cancelled);
        jpaRepo.deleteById(id);

        StockEntity stock = stockJpaRepository.findStockEntityByLaptop_serialNumber(reservation.getLaptop().getSerialNumber());
        stock.setQuantity(stock.getQuantity()+1);
        stockJpaRepository.save(stock);

        return true;
    }
    return false;
}

public Boolean finishReservation(Integer id) {
    Optional<ReservationEntity> optionalReservation = jpaRepo.findById(id);
    if (optionalReservation.isPresent()) {
        ReservationEntity reservation = optionalReservation.get();

        CompletedReservationEntity completed = new CompletedReservationEntity();
        completed.setReservationId(reservation.getReservationId());
        completed.setMessaging(reservation.getMessaging());
        completed.setMessagingPrice(reservation.getMessagingPrice());
        completed.setCreationDate(reservation.getCreationDate());
        completed.setPickupDate(reservation.getPickupDate());
        completed.setUser(reservation.getUser());
        completed.setLaptop(reservation.getLaptop());

        jpaCompletedRepo.save(completed);
        jpaRepo.deleteById(id);
        return true;
    }
    return false;
}
}