package com.masBarato.masBarato.service.useCase.Stock;

import com.masBarato.masBarato.model.classes.Stock;

public interface IStockPutInteractor {
    Boolean updateStock(Integer id, Stock stock);
}
