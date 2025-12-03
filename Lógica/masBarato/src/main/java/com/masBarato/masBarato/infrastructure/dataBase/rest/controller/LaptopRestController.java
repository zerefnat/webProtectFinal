package com.masBarato.masBarato.infrastructure.dataBase.rest.controller;


import com.masBarato.masBarato.domain.model.Laptop;
import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.in.inLaptopDto;
import com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.out.outLaptopDto;
import com.masBarato.masBarato.infrastructure.dataBase.sql.mapper.LaptopMapper;
import com.masBarato.masBarato.infrastructure.dataBase.sql.repository.LaptopJpaRepository;
import com.masBarato.masBarato.useCase.Laptop.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/laptop")
public class LaptopRestController {
    private final ILaptopAllInteractor laptopAllInteractor;
    private final ILaptopFindInteractor laptopFindInteractor;
    private final ILaptopPostInteractor laptopPostInteractor;
    private final ILaptopDeleteInteractor laptopDeleteInteractor;
    private final ILaptopPutInteractor laptopPutInteractor;

    @GetMapping("/allLaptop")
    public ResponseEntity<List<outLaptopDto>> allLaptops() {
        List<Laptop> laptops = laptopAllInteractor.allLaptops();
        if(laptops.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<outLaptopDto> outLaptopDtos = new ArrayList<>();
        for(Laptop laptop : laptops) {
            outLaptopDtos.add(outLaptopDto.fromLaptopToOutLaptopDto(laptop));
        }
        return ResponseEntity.ok(outLaptopDtos);
    }

    @GetMapping("/laptopId/{idLaptop}")
    public ResponseEntity<outLaptopDto> findLaptopById(@PathVariable Integer idLaptop) {
        Laptop laptop = laptopFindInteractor.findLaptopByLaptopId(idLaptop);
        if(laptop == null) {
            return ResponseEntity.noContent().build();
        }
        outLaptopDto LaptopDto= outLaptopDto.fromLaptopToOutLaptopDto(laptop);
        return ResponseEntity.ok(LaptopDto);
    }

    @PostMapping("")
    public boolean createLaptop(@RequestBody inLaptopDto laptopDto) {
        Laptop laptop = inLaptopDto.fromInLaptopDtoToLaptop(laptopDto);
        return laptopPostInteractor.newLaptop(laptop);
    }

    @DeleteMapping("/{idLaptop}")
    public boolean deleteLaptop(@PathVariable Integer idLaptop) {
        return laptopDeleteInteractor.delete(idLaptop);
    }

    @PutMapping("/{idLaptop}")
    public boolean updateLaptop(@PathVariable Integer idLaptop, @RequestBody inLaptopDto laptopDto) {
        Laptop laptop= inLaptopDto.fromInLaptopDtoToLaptop(laptopDto);
        return laptopPutInteractor.updateLaptop(idLaptop,laptop);
    }
}
