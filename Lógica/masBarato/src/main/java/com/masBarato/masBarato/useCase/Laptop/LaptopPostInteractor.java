package com.masBarato.masBarato.useCase.Laptop;

import com.masBarato.masBarato.domain.model.Laptop;
import com.masBarato.masBarato.domain.repository.ILaptopRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LaptopPostInteractor implements ILaptopPostInteractor{
    private final ILaptopRepositoryPort laptopRepositoryPort;

    @Override
    public boolean newLaptop(Laptop laptop) {
        return laptopRepositoryPort.newLaptop(laptop);
    }
}
