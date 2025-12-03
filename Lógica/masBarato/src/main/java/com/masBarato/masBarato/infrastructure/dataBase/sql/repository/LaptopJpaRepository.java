package com.masBarato.masBarato.infrastructure.dataBase.sql.repository;

import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopJpaRepository extends JpaRepository<LaptopEntity, Integer> {
    LaptopEntity findLaptopEntityByIdLaptop(Integer laptopId);
}
