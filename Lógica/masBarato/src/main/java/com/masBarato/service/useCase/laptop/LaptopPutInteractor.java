package com.masBarato.masBarato.service.useCase.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Laptop;
import com.masBarato.masBarato.service.LaptopServices;

@RequiredArgsConstructor
@Component
public class LaptopPutInteractor implements ILaptopPutInteractor{
    private final LaptopServices laptopRepositoryPort;

    @Override
    public boolean updateLaptop(String laptopId, Laptop laptop) {
        return laptopRepositoryPort.updateLaptop(laptopId,laptop);
    }
}
