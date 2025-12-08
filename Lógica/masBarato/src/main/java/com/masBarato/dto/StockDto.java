package com.masBarato.masBarato.dto;

import com.masBarato.masBarato.model.classes.Stock;

public record StockDto(
        Integer stockId,
        Boolean increase,
        Integer quantity,
        String userId,
        String laptopId
) {
    public static StockDto fromDomain(Stock stock) {
        if (stock == null) return null;
        return new StockDto(
                stock.getStockId(),
                stock.getIncrease(),
                stock.getQuantity(),
                stock.getUserId(),
                stock.getLaptopId()
        );
    }

    public static Stock toDomain(StockDto dto) {
        if (dto == null) return null;
        return new Stock(
                dto.stockId(),
                dto.increase(),
                dto.quantity(),
                dto.userId(),
                dto.laptopId()
        );
    }
}