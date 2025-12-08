package com.masBarato.masBarato.model.classes;

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
    private String userId;
    private String laptopId;

}