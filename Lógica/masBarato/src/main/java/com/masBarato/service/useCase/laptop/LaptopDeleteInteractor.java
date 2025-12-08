package com.masBarato.masBarato.service.useCase.laptop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.masBarato.masBarato.service.LaptopServices;

@RequiredArgsConstructor
@Component
public class LaptopDeleteInteractor implements ILaptopDeleteInteractor{
    private final LaptopServices laptopRepository;

    @Override
    public boolean delete(String idLaptop) {
        return laptopRepository.delete(idLaptop);
    }
}
