package com.masBarato.masBarato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masBarato.masBarato.model.entity.LaptopEntity;

public interface LaptopJpaRepository extends JpaRepository<LaptopEntity, String> {
    LaptopEntity findLaptopEntityBySerialNumber(String serialNumber);
}