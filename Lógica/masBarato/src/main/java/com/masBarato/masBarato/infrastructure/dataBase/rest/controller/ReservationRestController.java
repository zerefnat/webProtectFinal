package com.masBarato.masBarato.infrastructure.dataBase.rest.controller;

import com.masBarato.masBarato.domain.model.Reservation;
import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.ReservationDto;
import com.masBarato.masBarato.useCase.Reservation.IReservationDeleteInteractor;
import com.masBarato.masBarato.useCase.Reservation.IReservationFindInteractor;
import com.masBarato.masBarato.useCase.Reservation.IReservationPostInteractor;
import com.masBarato.masBarato.useCase.Reservation.IReservationPutInteractor;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    private final IReservationFindInteractor findInteractor;
    private final IReservationPostInteractor postInteractor;
    private final IReservationPutInteractor putInteractor;
    private final IReservationDeleteInteractor deleteInteractor;

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationDto> findReservationByReservationId(@PathVariable Integer id) {
        Optional<Reservation> reservation = Optional.ofNullable(findInteractor.findReservationByReservationId(id));
        if (reservation.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ReservationDto.fromDomain(reservation.get()));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReservationDto>> findReservationsByUserId(@PathVariable Integer userId) {
        Optional<List<Reservation>> optionalReservations = Optional.ofNullable(findInteractor.findReservationByUserId(userId));
        if (optionalReservations.isEmpty() || optionalReservations.get().isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        List<ReservationDto> dtoList = optionalReservations.get().stream().map(ReservationDto::fromDomain).toList(); 
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping("")
    public boolean createReservation(@RequestBody ReservationDto dto) {
        Reservation reservation = ReservationDto.toDomain(dto);
        return postInteractor.newReservation(reservation);
    }

    @PutMapping("/{reservationId}")
    public boolean updateReservation(@PathVariable Integer id, @RequestBody ReservationDto dto) {
        Reservation reservation = ReservationDto.toDomain(dto);
        return putInteractor.updateReservation(id, reservation);
    }

    @DeleteMapping("/{reservationId}")
    public boolean deleteReservationById(@PathVariable Integer id) {
        return deleteInteractor.deleteReservationByReservationId(id);
    }
}