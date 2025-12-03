package com.masBarato.masBarato.useCase.Laptop;

import com.masBarato.masBarato.domain.model.Laptop;
import com.masBarato.masBarato.domain.repository.ILaptopRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LaptopAllInteractor implements ILaptopAllInteractor{

    private final ILaptopRepositoryPort iLaptopRepositoryPort;

    @Override
    public List<Laptop> allLaptops() {
        return iLaptopRepositoryPort.allLaptops();
    }
}
