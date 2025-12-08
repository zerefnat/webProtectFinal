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
import com.masBarato.masBarato.model.classes.MemoriaRam;
import com.masBarato.masBarato.model.classes.Pantalla;
import com.masBarato.masBarato.model.classes.Procesador;
import com.masBarato.masBarato.model.classes.SistemaOparativo;
import com.masBarato.masBarato.model.classes.Stock;
import com.masBarato.masBarato.model.classes.TarjetaVideo;
import com.masBarato.masBarato.service.useCase.MemoriaRam.IMemoriaRamFindInteractor;
import com.masBarato.masBarato.service.useCase.Pantalla.IPantallaFindInteractor;
import com.masBarato.masBarato.service.useCase.SistemaOperativo.ISistemaOperativoFindInteractor;
import com.masBarato.masBarato.service.useCase.TarjetaVideo.ITarjetaVideoFindInteractor;
import com.masBarato.masBarato.service.useCase.almacenamiento.IAlmacenamientoFindInteractor;
import com.masBarato.masBarato.service.useCase.distribucionTeclado.IDistribucionTecladoFindInteractor;
import com.masBarato.masBarato.service.useCase.laptop.ILaptopAllInteractor;
import com.masBarato.masBarato.service.useCase.laptop.ILaptopDeleteInteractor;
import com.masBarato.masBarato.service.useCase.laptop.ILaptopFindInteractor;
import com.masBarato.masBarato.service.useCase.laptop.ILaptopPostInteractor;
import com.masBarato.masBarato.service.useCase.laptop.ILaptopPutInteractor;
import com.masBarato.masBarato.service.useCase.marca.IMarcaFindInteractor;
import com.masBarato.masBarato.service.useCase.procesador.IProcesadorFindInteractor;

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
    private final ISistemaOperativoFindInteractor soFindInteractot;
    private final IMemoriaRamFindInteractor memoriaRamFindInteractot;
    private final ITarjetaVideoFindInteractor tarjetaVideoFindInteractot;
    private final IProcesadorFindInteractor procesadorFindInteractot;
    private final IPantallaFindInteractor pantallaFindInteractor;

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
            Procesador procesador = procesadorFindInteractot.findProcesadorByIdProcesador(laptop.getProcesador());
            SistemaOparativo sistemaOperativo1 = soFindInteractot.findSOByIdSO(laptop.getSistemaOperativo1());
            SistemaOparativo sistemaOperativo2 = soFindInteractot.findSOByIdSO(laptop.getSistemaOperativo2());
            MemoriaRam memoriaRam1 = memoriaRamFindInteractot.findMemoriaRamByIdMemoriaRam(laptop.getMemoriaRam1());
            MemoriaRam memoriaRam2 = memoriaRamFindInteractot.findMemoriaRamByIdMemoriaRam(laptop.getMemoriaRam2()); 
            TarjetaVideo tarjetaVideo = tarjetaVideoFindInteractot.findTarjetaByIdTarjeta(laptop.getTarjetaVideo());
            Pantalla pantalla = pantallaFindInteractor.findPantallaEntityByIdPantalla(laptop.getPantalla());
            outLaptopDtos.add(outLaptopDto.fromLaptopToOutLaptopDto(laptop,almacenamiento,dt.getNombreDistribucionTeclado(),marca.getNombreMarca(), procesador.getNombreProcesador(), sistemaOperativo1.getNombreSO(), sistemaOperativo2.getNombreSO(), memoriaRam1.getName(), memoriaRam2.getName(),tarjetaVideo.getNombreTarjetaVideo(), pantalla));
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
        Procesador procesador = procesadorFindInteractot.findProcesadorByIdProcesador(laptop.getProcesador());
         SistemaOparativo sistemaOperativo1 = soFindInteractot.findSOByIdSO(laptop.getSistemaOperativo1());
            SistemaOparativo sistemaOperativo2 = soFindInteractot.findSOByIdSO(laptop.getSistemaOperativo2());
            MemoriaRam memoriaRam1 = memoriaRamFindInteractot.findMemoriaRamByIdMemoriaRam(laptop.getMemoriaRam1());
            MemoriaRam memoriaRam2 = memoriaRamFindInteractot.findMemoriaRamByIdMemoriaRam(laptop.getMemoriaRam2()); 
            TarjetaVideo tarjetaVideo = tarjetaVideoFindInteractot.findTarjetaByIdTarjeta(laptop.getTarjetaVideo());
            Pantalla pantalla = pantallaFindInteractor.findPantallaEntityByIdPantalla(laptop.getPantalla());
            outLaptopDto LaptopDto= outLaptopDto.fromLaptopToOutLaptopDto(laptop,almacenamiento,dt.getNombreDistribucionTeclado(),marca.getNombreMarca(), procesador.getNombreProcesador(), sistemaOperativo1.getNombreSO(), sistemaOperativo2.getNombreSO(), memoriaRam1.getName(), memoriaRam2.getName(),tarjetaVideo.getNombreTarjetaVideo(), pantalla);
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
