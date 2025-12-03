package com.masBarato.masBarato.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CancelledReservation {
    private Integer reservationId;
    private Boolean messaging;
    private Float messagingPrice;
    private String creationDate;
    private Integer userId;
    private Integer laptopId;
}