package com.masBarato.masBarato.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masBarato.masBarato.dto.CompletedReservationDto;
import com.masBarato.masBarato.model.classes.CompletedReservation;
import com.masBarato.masBarato.service.useCase.CompletedReservation.ICompletedReservationFindInteractor;
import com.masBarato.masBarato.service.useCase.CompletedReservation.ICompletedReservationPostInteractor;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/completed-reservation")
public class CompletedReservationRestController {
    private final ICompletedReservationFindInteractor findInteractor;
    private final ICompletedReservationPostInteractor postInteractor;

    @GetMapping("/{reservationId}")
    public ResponseEntity<CompletedReservationDto> findById(Integer id) {
        Optional<CompletedReservation> reservation = Optional.ofNullable(findInteractor.findReservationByReservationId(id));
        if (reservation.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(CompletedReservationDto.fromDomain(reservation.get()));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CompletedReservationDto>> findReservationsByUserId(@PathVariable String userId) {
        Optional<List<CompletedReservation>> optionalReservations = Optional.ofNullable(findInteractor.findReservationByUserId(userId));
        if (optionalReservations.isEmpty() || optionalReservations.get().isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        List<CompletedReservationDto> dtoList = optionalReservations.get().stream().map(CompletedReservationDto::fromDomain).toList(); 
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping("")
    public boolean create(@RequestBody CompletedReservationDto dto) {
        CompletedReservation reservation = CompletedReservationDto.toDomain(dto);
        return postInteractor.newCompletedReservation(reservation);
    }
}