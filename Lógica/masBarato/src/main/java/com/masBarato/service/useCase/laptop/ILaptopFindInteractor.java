package com.masBarato.masBarato.service.useCase.laptop;

import com.masBarato.masBarato.model.classes.Laptop;

public interface ILaptopFindInteractor {
    Laptop findLaptopByLaptopId(String laptopId);
}
