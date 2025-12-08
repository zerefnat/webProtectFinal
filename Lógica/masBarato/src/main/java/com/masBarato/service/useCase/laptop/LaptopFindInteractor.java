package com.masBarato.masBarato.service.useCase.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.model.classes.Laptop;
import com.masBarato.masBarato.service.LaptopServices;

@RequiredArgsConstructor
@Component
public class LaptopFindInteractor implements ILaptopFindInteractor{
    private final LaptopServices laptopRepository;

    @Override
    public Laptop findLaptopByLaptopId(String laptopId) {
        return laptopRepository.findLaptopByLaptopId(laptopId);
    }
}
