package com.masBarato.masBarato.useCase.Laptop;

import com.masBarato.masBarato.domain.model.Laptop;

public interface ILaptopPutInteractor {
    boolean updateLaptop(Integer laptopId,Laptop laptop);
}
