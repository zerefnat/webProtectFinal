package com.masBarato.masBarato.dto.out;

import com.masBarato.masBarato.model.classes.Almacenamiento;
import com.masBarato.masBarato.model.classes.Laptop;

import java.util.Date;

public record outLaptopDto(
          String serialNumber,
          String laptopModel,
          Date laptopDate,
          String urlImagen,
          String description,
          Float precio,
          Float descuento,
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
          String userId
) {
    public static outLaptopDto fromLaptopToOutLaptopDto(Laptop laptop, Almacenamiento almacenamiento,String dtName,String marcaName) {
        return new outLaptopDto(
                laptop.getSerialNumber(),
                laptop.getLaptopModel(),
                laptop.getLaptopDate(),
                laptop.getUrlImagen(),
                laptop.getDescription(),
                laptop.getPrecio(),
                laptop.getDescuento(),
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
