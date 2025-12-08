package com.masBarato.masBarato.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.masBarato.masBarato.mapper.LaptopMapper;
import com.masBarato.masBarato.model.classes.Laptop;
import com.masBarato.masBarato.model.classes.Stock;
import com.masBarato.masBarato.model.entity.LaptopEntity;
import com.masBarato.masBarato.repository.LaptopJpaRepository;
import com.masBarato.masBarato.repository.StockJpaRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class LaptopServices {
    private final LaptopJpaRepository laptopJpaRepository;
    private final StockJpaRepository stockJpaRepository;

    public List<Laptop> allLaptops() {
        List<LaptopEntity> laptopEntities = laptopJpaRepository.findAll();
        List<Laptop> laptops = new ArrayList<>();
        for (LaptopEntity laptopEntity : laptopEntities) {
            laptops.add(LaptopMapper.fromLaptopEntityToLaptop(laptopEntity));
        }
        return laptops;
    }

    public Laptop findLaptopByLaptopId(String serialNumber) {
        LaptopEntity laptopEntity = laptopJpaRepository.findLaptopEntityBySerialNumber(serialNumber);
        return LaptopMapper.fromLaptopEntityToLaptop(laptopEntity);
    }

    @Transactional
    public boolean newLaptop(Laptop laptop, Stock stock) {
        LaptopEntity laptopEntity = LaptopMapper.fromLaptopToLaptopEntity(laptop);
        laptopJpaRepository.save(laptopEntity);
        final StockService stockRepositoryAdapter = new StockService(stockJpaRepository);
        stockRepositoryAdapter.newStock(stock);
        return findLaptopByLaptopId(laptop.getSerialNumber()) != null;
    }

    public boolean delete(String idLaptop) {
        laptopJpaRepository.deleteById(idLaptop);
        return findLaptopByLaptopId(idLaptop) == null;
    }

    public boolean updateLaptop(String laptopId,Laptop laptop) {
        LaptopEntity laptopEntity= laptopJpaRepository.findLaptopEntityBySerialNumber(laptopId);
        if(laptopEntity == null) {
            return false;
        }
        LaptopEntity updateLaptopEntity = LaptopMapper.fromLaptopToLaptopEntity(laptop);
        updateLaptopEntity.setSerialNumber(laptopId);
        laptopJpaRepository.save(updateLaptopEntity);
        return true;
    }
}
