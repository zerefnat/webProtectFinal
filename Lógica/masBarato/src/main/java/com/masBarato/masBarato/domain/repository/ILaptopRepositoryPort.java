package com.masBarato.masBarato.domain.repository;

import com.masBarato.masBarato.domain.model.Laptop;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;


public interface ILaptopRepositoryPort {
    List<Laptop> allLaptops();
    Laptop findLaptopByLaptopId(Integer laptopId);
    boolean newLaptop(Laptop laptop);
    boolean delete(Integer idLaptop);
    boolean updateLaptop(Integer laptopId,Laptop laptop);
}
