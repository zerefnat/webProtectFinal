package com.masBarato.masBarato.service.useCase.Stock;

import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Stock;
import com.masBarato.masBarato.service.StockService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StockPutInteractor implements IStockPutInteractor{
    private final StockService stockRepositoryPort;

    @Override
    public Boolean updateStock(Integer id, Stock stock) {
        return stockRepositoryPort.updateStock(id, stock);
    }
}
