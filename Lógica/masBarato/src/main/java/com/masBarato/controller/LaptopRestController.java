package com.masBarato.masBarato.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masBarato.masBarato.dto.StockDto;
import com.masBarato.masBarato.dto.in.inLaptopDto;
import com.masBarato.masBarato.dto.out.outLaptopDto;
import com.masBarato.masBarato.model.classes.Almacenamiento;
import com.masBarato.masBarato.model.classes.DistribucionTeclado;
import com.masBarato.masBarato.model.classes.Laptop;
import com.masBarato.masBarato.model.classes.Marca;
import com.masBarato.masBarato.model.classes.Stock;
import com.masBarato.masBarato.service.useCase.almacenamiento.IAlmacenamientoFindInteractor;
import com.masBarato.masBarato.service.useCase.distribucionTeclado.IDistribucionTecladoFindInteractor;
import com.masBarato.masBarato.service.useCase.laptop.ILaptopAllInteractor;
import com.masBarato.masBarato.service.useCase.laptop.ILaptopDeleteInteractor;
import com.masBarato.masBarato.service.useCase.laptop.ILaptopFindInteractor;
import com.masBarato.masBarato.service.useCase.laptop.ILaptopPostInteractor;
import com.masBarato.masBarato.service.useCase.laptop.ILaptopPutInteractor;
import com.masBarato.masBarato.service.useCase.marca.IMarcaFindInteractor;

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
    private final IAlmacenamientoFindInteractor almacenamientoFindInteractor;
    private final IDistribucionTecladoFindInteractor dtFindInteractor;
    private final IMarcaFindInteractor marcaFindInteractor;

    @GetMapping("/allLaptop")
    public ResponseEntity<List<outLaptopDto>> allLaptops() {
        List<Laptop> laptops = laptopAllInteractor.allLaptops();
        if(laptops.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<outLaptopDto> outLaptopDtos = new ArrayList<>();
        for(Laptop laptop : laptops) {
            Almacenamiento almacenamiento=almacenamientoFindInteractor.findAlmacenamientoByIdAlmacenamiento(laptop.getAlmacenamiento());
            DistribucionTeclado dt = dtFindInteractor.findDistribucionTecladoById(laptop.getDistribucionTeclado());
            Marca marca= marcaFindInteractor.findMarcaByIdMarca(laptop.getMarca());
            outLaptopDtos.add(outLaptopDto.fromLaptopToOutLaptopDto(laptop,almacenamiento,dt.getNombreDistribucionTeclado(),marca.getNombreMarca()));
        }
        return ResponseEntity.ok(outLaptopDtos);
    }

    @GetMapping("/laptopId/{serialNumber}")
    public ResponseEntity<outLaptopDto> findLaptopById(@PathVariable String serialNumber) {
        Laptop laptop = laptopFindInteractor.findLaptopByLaptopId(serialNumber);
        if(laptop == null) {
            return ResponseEntity.noContent().build();
        }
        Almacenamiento almacenamiento=almacenamientoFindInteractor.findAlmacenamientoByIdAlmacenamiento(laptop.getAlmacenamiento());
        DistribucionTeclado dt = dtFindInteractor.findDistribucionTecladoById(laptop.getDistribucionTeclado());
        Marca marca= marcaFindInteractor.findMarcaByIdMarca(laptop.getMarca());
        outLaptopDto LaptopDto= outLaptopDto.fromLaptopToOutLaptopDto(laptop,almacenamiento,dt.getNombreDistribucionTeclado(), marca.getNombreMarca());
        return ResponseEntity.ok(LaptopDto);
    }

    @PostMapping("")
    public boolean createLaptop(@RequestBody inLaptopDto laptopDto, StockDto stockDto) {
        Laptop laptop = inLaptopDto.fromInLaptopDtoToLaptop(laptopDto);
        Stock stock = StockDto.toDomain(stockDto);
        return laptopPostInteractor.newLaptop(laptop, stock);
    }

    @DeleteMapping("/{serialNumber}")
    public boolean deleteLaptop(@PathVariable String serialNumber) {
        return laptopDeleteInteractor.delete(serialNumber);
    }

    @PutMapping("/{serialNumber}")
    public boolean updateLaptop(@PathVariable String serialNumber, @RequestBody inLaptopDto laptopDto) {
        Laptop laptop= inLaptopDto.fromInLaptopDtoToLaptop(laptopDto);
        return laptopPutInteractor.updateLaptop(serialNumber,laptop);
    }
}
