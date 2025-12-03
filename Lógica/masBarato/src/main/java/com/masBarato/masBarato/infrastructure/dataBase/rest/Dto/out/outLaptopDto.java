package com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.out;

import com.masBarato.masBarato.domain.model.Laptop;

import java.util.Date;

public record outLaptopDto(
          Integer laptopId,
          String laptopModel,
          Date laptopDate,
          String urlImagen,
          Integer marca,
          Integer procesador,
          Integer pantalla,
          Integer distribucionTeclado,
          Integer almacenamiento,
          Integer sistemaOperativo1,
          Integer sistemaOperativo2,
          Integer memoriaRam1,
          Integer memoriaRam2,
          Integer tarjetaVideo,
          Integer userId
) {
    public static outLaptopDto fromLaptopToOutLaptopDto(Laptop laptop) {
        return new outLaptopDto(
                laptop.getLaptopId(),
                laptop.getLaptopModel(),
                laptop.getLaptopDate(),
                laptop.getUrlImagen(),
                laptop.getMarca(),
                laptop.getProcesador(),
                laptop.getPantalla(),
                laptop.getDistribucionTeclado(),
                laptop.getAlmacenamiento(),
                laptop.getSistemaOperativo1(),
                laptop.getSistemaOperativo2(),
                laptop.getMemoriaRam1(),
                laptop.getMemoriaRam2(),
                laptop.getTarjetaVideo(),
                laptop.getUserId()
        );
    }
}
