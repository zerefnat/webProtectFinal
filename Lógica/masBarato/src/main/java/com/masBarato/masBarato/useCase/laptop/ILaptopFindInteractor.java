package com.masBarato.masBarato.useCase.laptop;

import com.masBarato.masBarato.domain.model.Laptop;

public interface ILaptopFindInteractor {
    Laptop findLaptopByLaptopId(Integer laptopId);
}
