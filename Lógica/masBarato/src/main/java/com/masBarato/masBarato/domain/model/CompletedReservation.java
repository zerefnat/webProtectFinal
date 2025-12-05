package com.masBarato.masBarato.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CompletedReservation {
    private Integer reservationId;
    private Boolean messaging;
    private Float messagingPrice;
    private Date creationDate;
    private Date pickupDate;
    private Integer userId;
    private Integer laptopId;
}