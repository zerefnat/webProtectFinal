package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.StockEntity;

public interface StockJpaRepository extends JpaRepository<StockEntity, Integer> {
    StockEntity findStockEntityByStockId(Integer stockId);
    StockEntity findStockEntityByLaptop_serialNumber(String laptopId);
}
