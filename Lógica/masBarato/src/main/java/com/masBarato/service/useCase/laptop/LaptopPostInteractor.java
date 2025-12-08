package com.masBarato.masBarato.service.useCase.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Laptop;
import com.masBarato.masBarato.model.classes.Stock;
import com.masBarato.masBarato.service.LaptopServices;

@RequiredArgsConstructor
@Component
public class LaptopPostInteractor implements ILaptopPostInteractor{
    private final LaptopServices laptopRepositoryPort;

    @Override
    public boolean newLaptop(Laptop laptop, Stock stock) {
        return laptopRepositoryPort.newLaptop(laptop, stock);
    }
}
