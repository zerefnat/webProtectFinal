package com.masBarato.masBarato.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Stock {
    private Integer stockId;
    private Boolean increase;
    private Integer quantity;
    private String userId;
    private String laptopId;
}
