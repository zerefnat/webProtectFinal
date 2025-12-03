package com.masBarato.masBarato.infrastructure.dataBase.sql.adapter;

import com.masBarato.masBarato.domain.model.Laptop;
import com.masBarato.masBarato.domain.repository.ILaptopRepositoryPort;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.LaptopEntity;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.LaptopMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.LaptopJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class LaptopRepositoryAdapter implements ILaptopRepositoryPort {
    private final LaptopJpaRepository laptopJpaRepository;

    @Override
    public List<Laptop> allLaptops() {
        List<LaptopEntity> laptopEntities = laptopJpaRepository.findAll();
        List<Laptop> laptops = new ArrayList<>();
        for (LaptopEntity laptopEntity : laptopEntities) {
            laptops.add(LaptopMapper.fromLaptopEntityToLaptop(laptopEntity));
        }
        return laptops;
    }

    @Override
    public Laptop findLaptopByLaptopId(Integer laptopId) {
        LaptopEntity laptopEntity = laptopJpaRepository.findLaptopEntityByIdLaptop(laptopId);
        return LaptopMapper.fromLaptopEntityToLaptop(laptopEntity);
    }

    @Override
    public boolean newLaptop(Laptop laptop) {
        LaptopEntity laptopEntity = LaptopMapper.fromLaptopToLaptopEntity(laptop);
        laptopJpaRepository.save(laptopEntity);
        return findLaptopByLaptopId(laptop.getLaptopId()) != null;
    }

    @Override
    public boolean delete(Integer idLaptop) {
        laptopJpaRepository.deleteById(idLaptop);
        return findLaptopByLaptopId(idLaptop) == null;
    }

    @Override
    public boolean updateLaptop(Integer laptopId,Laptop laptop) {
        LaptopEntity laptopEntity= laptopJpaRepository.findLaptopEntityByIdLaptop(laptopId);
        if(laptopEntity == null) {
            return false;
        }
        LaptopEntity updateLaptopEntity = LaptopMapper.fromLaptopToLaptopEntity(laptop);
        updateLaptopEntity.setIdLaptop(laptopId);
        laptopJpaRepository.save(updateLaptopEntity);
        return true;
    }
}
