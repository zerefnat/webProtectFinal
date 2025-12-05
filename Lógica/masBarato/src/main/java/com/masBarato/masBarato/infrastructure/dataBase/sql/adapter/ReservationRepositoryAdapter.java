package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import com.masBarato.masBarato.domain.model.CancelledReservation;
import com.masBarato.masBarato.domain.model.CompletedReservation;
import com.masBarato.masBarato.domain.model.Reservation;
import com.masBarato.masBarato.domain.repository.IReservationRepositoryPort;
import com.masBarato.masBarato.domain.repository.ICancelledReservationRepositoryPort;
import com.masBarato.masBarato.domain.repository.ICompletedReservationRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.ReservationEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.CancelledReservationEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.CompletedReservationEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.ReservationMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.ReservationJpaRepository;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.CancelledReservationJpaRepository;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.CompletedReservationJpaRepository;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationRepositoryAdapter implements IReservationRepositoryPort{
    private final ReservationJpaRepository jpaRepo;
    private final CancelledReservationJpaRepository jpaCancelledRepo;
    private final CompletedReservationJpaRepository jpaCompletedRepo;
    @Override
    public Reservation findReservationByReservationId(Integer id) {
        ReservationEntity entity = jpaRepo.findReservationEntityByReservationId(id);
        return ReservationMapper.fromEntityToDomain(entity);
    }

    @Override
    public List<Reservation> findReservationByUserId(Integer id) {
        List<ReservationEntity> entity = jpaRepo.findReservationEntityByUser_UserId(id);
        return ReservationMapper.fromEntityListToDomainList(entity);
    }

    @Override
    public Boolean newReservation(Reservation reservation) {
        ReservationEntity entity = ReservationMapper.fromDomainToEntity(reservation);
        jpaRepo.save(entity);
        return findReservationByReservationId(entity.getReservationId()) == null;
    }

    @Override
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

    @Override
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
        return true;
    }
    return false;
}

    @Override
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
