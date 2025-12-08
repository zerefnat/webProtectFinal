package com.masBarato.masBarato.service.useCase.Stock;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Stock;
import com.masBarato.masBarato.service.StockService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StockFindInteractor implements IStockFindInteractor{
    private final StockService stockRepositoryPort;

    @Override
    public Stock findById(Integer id) {
        return stockRepositoryPort.findById(id);
    }

    @Override
    public Stock findByLaptopId(String id) {
        return stockRepositoryPort.findByLaptopId(id);
    }    
}
