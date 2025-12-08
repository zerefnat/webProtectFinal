package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.Stock;
import com.masBarato.masBarato.model.entity.LaptopEntity;
import com.masBarato.masBarato.model.entity.StockEntity;
import com.masBarato.masBarato.model.entity.UserEntity;

public class StockMapper {
    public static Stock fromEntityToDomain(StockEntity entity) {
        if (entity == null) return null;
        return new Stock(
                entity.getStockId(),
                entity.getIncrease(),
                entity.getQuantity(),
                entity.getUser().getUserId(),
                entity.getLaptop().getSerialNumber()
        );
    }

    public static StockEntity fromDomainToEntity(Stock stock) {
        StockEntity entity = new StockEntity();
        entity.setStockId(stock.getStockId());
        entity.setIncrease(stock.getIncrease());
        entity.setQuantity(stock.getQuantity());

        UserEntity user = new UserEntity();
        user.setUserId(stock.getUserId());
        entity.setUser(user);

        LaptopEntity laptop = new LaptopEntity();
        laptop.setSerialNumber(stock.getLaptopId());
        entity.setLaptop(laptop);

        return entity;
    }
}