package com.masBarato.masBarato.service.useCase.laptop;

import com.masBarato.masBarato.model.classes.Laptop;

public interface ILaptopPutInteractor {
    boolean updateLaptop(String laptopId,Laptop laptop);
}
