package com.masBarato.masBarato.service;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.mapper.StockMapper;
import com.masBarato.masBarato.model.classes.Stock;
import com.masBarato.masBarato.model.entity.StockEntity;
import com.masBarato.masBarato.repository.StockJpaRepository;

@Component
@RequiredArgsConstructor
public class StockService{
    private final StockJpaRepository jpaRepo;

    public Stock findById(Integer id) {
        StockEntity entity = jpaRepo.findStockEntityByStockId(id);
        return StockMapper.fromEntityToDomain(entity);
    }

    public Stock findByLaptopId(String id) {
        StockEntity entity = jpaRepo.findStockEntityByLaptop_serialNumber(id);
        return StockMapper.fromEntityToDomain(entity);
    }

    public Boolean newStock(Stock stock) {
        StockEntity entity = StockMapper.fromDomainToEntity(stock);
        jpaRepo.save(entity);
        return true;
    }

    public Boolean updateStock(Integer id, Stock stock) {
        Optional<StockEntity> optionalReservationEntity = Optional.ofNullable(jpaRepo.findStockEntityByStockId(id));
        if(optionalReservationEntity.isEmpty()) {
            return false;
        }
        StockEntity entity = StockMapper.fromDomainToEntity(stock);
        entity.setStockId(id);
        jpaRepo.save(entity);
        return true;
    }
}