package com.masBarato.masBarato.useCase.Laptop;

import com.masBarato.masBarato.domain.repository.ILaptopRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LaptopDeleteInteractor implements ILaptopDeleteInteractor{
    private final ILaptopRepositoryPort laptopRepository;

    @Override
    public boolean delete(Integer idLaptop) {
        return laptopRepository.delete(idLaptop);
    }
}
