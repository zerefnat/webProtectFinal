package com.masBarato.masBarato.useCase.laptop;

import com.masBarato.masBarato.domain.model.Laptop;
import com.masBarato.masBarato.domain.repository.ILaptopRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LaptopPutInteractor implements ILaptopPutInteractor{
    private final ILaptopRepositoryPort laptopRepositoryPort;

    @Override
    public boolean updateLaptop(Integer laptopId, Laptop laptop) {
        return laptopRepositoryPort.updateLaptop(laptopId,laptop);
    }
}
