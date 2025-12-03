package com.masBarato.masBarato.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Reservation {
    private Integer reservationId;
    private Boolean messaging;
    private Float messagingPrice;
    private String creationDate;
    private String pickupDate;
    private Boolean archived;
    private Integer userId;
    private Integer laptopId;
}
