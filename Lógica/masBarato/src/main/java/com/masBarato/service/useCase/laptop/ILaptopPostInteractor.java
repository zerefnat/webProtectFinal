package com.masBarato.masBarato.service.useCase.laptop;

import com.masBarato.masBarato.model.classes.Laptop;
import com.masBarato.masBarato.model.classes.Stock;

public interface ILaptopPostInteractor {
    boolean newLaptop(Laptop laptop, Stock stock);
}
