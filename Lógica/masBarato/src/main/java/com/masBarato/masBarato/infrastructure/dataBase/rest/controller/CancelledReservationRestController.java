package com.masBarato.masBarato.infrastructure.dataBase.rest.controller;

import com.masBarato.masBarato.domain.model.CancelledReservation;
import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.CancelledReservationDto;
import com.masBarato.masBarato.useCase.cancelledReservation.ICancelledReservationPostInteractor;
import com.masBarato.masBarato.useCase.cancelledReservation.ICancelledReservationPutInteractor;
import com.masBarato.masBarato.useCase.cancelledReservation.ICancelledReservationFindInteractor;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cancelled-reservation")
public class CancelledReservationRestController {
    private final ICancelledReservationFindInteractor findInteractor;
    private final ICancelledReservationPostInteractor postInteractor;
    private final ICancelledReservationPutInteractor putInteractor;

    @GetMapping("/{reservationId}")
    public ResponseEntity<CancelledReservationDto> findReservationByReservationId(@PathVariable Integer id) {
        Optional<CancelledReservation> reservation = Optional.ofNullable(findInteractor.findReservationByReservationId(id));
        if (reservation.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(CancelledReservationDto.fromDomain(reservation.get()));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CancelledReservationDto>> findReservationsByUserId(@PathVariable Integer userId) {
        Optional<List<CancelledReservation>> optionalReservations = Optional.ofNullable(findInteractor.findReservationByUserId(userId));
        if (optionalReservations.isEmpty() || optionalReservations.get().isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        List<CancelledReservationDto> dtoList = optionalReservations.get().stream().map(CancelledReservationDto::fromDomain).toList(); 
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping("")
    public boolean createCancelledReservation(@RequestBody CancelledReservationDto dto) {
        CancelledReservation reservation = CancelledReservationDto.toDomain(dto);
        return postInteractor.newCancelledReservation(reservation);
    }

    @PutMapping("/{id}")
    public boolean updateCancelledReservation(@PathVariable Integer id, @RequestBody CancelledReservationDto dto) {
        CancelledReservation reservation = CancelledReservationDto.toDomain(dto);
        return putInteractor.updateCancelledReservation(id, reservation);
    }
}