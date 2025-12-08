package com.masBarato.masBarato.service.useCase.Stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Stock;
import com.masBarato.masBarato.service.StockService;

@RequiredArgsConstructor
@Component
public class StockPostInteractor implements IStockPostInteractor{
    private final StockService stockRepositoryPort;

    @Override
    public Boolean newStock(Stock stock) {
        return stockRepositoryPort.newStock(stock);
    }
}