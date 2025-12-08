package com.masBarato.masBarato.service.useCase.Stock;

import com.masBarato.masBarato.model.classes.Stock;

public interface IStockFindInteractor {
    Stock findById(Integer id);
    Stock findByLaptopId(String id);
}
