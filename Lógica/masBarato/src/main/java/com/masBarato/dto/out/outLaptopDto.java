package com.masBarato.masBarato.dto.out;

import com.masBarato.masBarato.model.classes.Almacenamiento;
import com.masBarato.masBarato.model.classes.Laptop;
import com.masBarato.masBarato.model.classes.Pantalla;

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
          String procesador,
          String pantalla,
          String distribucionTeclado,
          String almacenamiento,
          String  sistemaOperativo1,
          String  sistemaOperativo2,
           String  memoriaRam1,
           String memoriaRam2,
           String  tarjetaVideo,
          String userId
) {
    public static outLaptopDto fromLaptopToOutLaptopDto(Laptop laptop, Almacenamiento almacenamiento,String dtName,String marcaName, String procesador, String sistemaOperativo1, String sistemaOperativo2, String memoriaRam1, String memoriaRam2, String tarjetaVideo, Pantalla pantalla) {
        return new outLaptopDto(
                laptop.getSerialNumber(),
                laptop.getLaptopModel(),
                laptop.getLaptopDate(),
                laptop.getUrlImagen(),
                laptop.getDescription(),
                laptop.getPrecio(),
                laptop.getDescuento(),
                marcaName,
                procesador,
                pantalla.getAnchoPantalla()+" "+ pantalla.getAltoPantalla()+" "+ pantalla.getTecnologiaPantalla()+" "+pantalla.isEsTactil(),
                dtName,
                almacenamiento.getTipoAlmacenamiento()+" "+almacenamiento.getTamanioAlmacenamiento()+almacenamiento.getUnidadMedida(),
                sistemaOperativo1,
                sistemaOperativo2,
                memoriaRam1,
                memoriaRam2,
                tarjetaVideo,
                laptop.getUserId()
        );
    }
}
