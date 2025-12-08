package com.masBarato.masBarato.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masBarato.masBarato.dto.ReservationDto;
import com.masBarato.masBarato.model.classes.Reservation;
import com.masBarato.masBarato.service.useCase.Reservation.IReservationDeleteInteractor;
import com.masBarato.masBarato.service.useCase.Reservation.IReservationFindInteractor;
import com.masBarato.masBarato.service.useCase.Reservation.IReservationPostInteractor;
import com.masBarato.masBarato.service.useCase.Reservation.IReservationPutInteractor;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    private final IReservationFindInteractor findInteractor;
    private final IReservationPostInteractor postInteractor;
    private final IReservationPutInteractor putInteractor;
    private final IReservationDeleteInteractor deleteInteractor;

    @GetMapping("/reservationID/{reservationId}")
    public ResponseEntity<ReservationDto> findReservationByReservationId(@PathVariable Integer reservationId) {
        Optional<Reservation> reservation = Optional.ofNullable(findInteractor.findReservationByReservationId(reservationId));
        if (reservation.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ReservationDto.fromDomain(reservation.get()));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReservationDto>> findReservationsByUserId(@PathVariable String userId) {
        Optional<List<Reservation>> optionalReservations = Optional.ofNullable(findInteractor.findReservationByUserId(userId));
        if (optionalReservations.isEmpty() || optionalReservations.get().isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        List<ReservationDto> dtoList = optionalReservations.get().stream().map(ReservationDto::fromDomain).toList(); 
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping("")
    public boolean createReservation(@RequestBody ReservationDto dto, Integer stock) {
        Reservation reservation = ReservationDto.toDomain(dto);
        return postInteractor.newReservation(reservation, stock);
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