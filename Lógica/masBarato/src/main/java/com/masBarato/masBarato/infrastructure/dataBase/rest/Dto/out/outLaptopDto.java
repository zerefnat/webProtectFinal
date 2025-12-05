package com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.out;

import com.masBarato.masBarato.domain.model.Almacenamiento;
import com.masBarato.masBarato.domain.model.Laptop;

import java.util.Date;

public record outLaptopDto(
          Integer laptopId,
          String laptopModel,
          Date laptopDate,
          String urlImagen,
          String marca,
          Integer procesador,
          Integer pantalla,
          String distribucionTeclado,
          String almacenamiento,
          Integer sistemaOperativo1,
          Integer sistemaOperativo2,
          Integer memoriaRam1,
          Integer memoriaRam2,
          Integer tarjetaVideo,
          Integer userId
) {
    public static outLaptopDto fromLaptopToOutLaptopDto(Laptop laptop, Almacenamiento almacenamiento,String dtName,String marcaName) {
        return new outLaptopDto(
                laptop.getLaptopId(),
                laptop.getLaptopModel(),
                laptop.getLaptopDate(),
                laptop.getUrlImagen(),
                marcaName,
                laptop.getProcesador(),
                laptop.getPantalla(),
                dtName,
                almacenamiento.getTipoAlmacenamiento()+" "+almacenamiento.getTamanioAlmacenamiento()+almacenamiento.getUnidadMedida(),
                laptop.getSistemaOperativo1(),
                laptop.getSistemaOperativo2(),
                laptop.getMemoriaRam1(),
                laptop.getMemoriaRam2(),
                laptop.getTarjetaVideo(),
                laptop.getUserId()
        );
    }
}
