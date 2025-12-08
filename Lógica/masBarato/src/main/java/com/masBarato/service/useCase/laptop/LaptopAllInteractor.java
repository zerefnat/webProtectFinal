package com.masBarato.masBarato.service.useCase.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Laptop;
import com.masBarato.masBarato.service.LaptopServices;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LaptopAllInteractor implements ILaptopAllInteractor{

    private final LaptopServices iLaptopRepositoryPort;

    @Override
    public List<Laptop> allLaptops() {
        return iLaptopRepositoryPort.allLaptops();
    }
}
