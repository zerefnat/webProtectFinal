package com.masBarato.masBarato.useCase.laptop;

import com.masBarato.masBarato.domain.model.Laptop;
import com.masBarato.masBarato.domain.repository.ILaptopRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LaptopFindInteractor implements ILaptopFindInteractor{
    private final ILaptopRepositoryPort laptopRepository;


    @Override
    public Laptop findLaptopByLaptopId(Integer laptopId) {
        return laptopRepository.findLaptopByLaptopId(laptopId);
    }
}
