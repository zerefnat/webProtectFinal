package com.masBarato.masBarato.dto.in;



import java.util.Date;

import com.masBarato.masBarato.model.classes.Laptop;
 
public record inLaptopDto(
        String serialNumber,
        String laptopModel,
        Date laptopDate,
        String urlImagen,
        String description,
        Float precio,
        Float descuento,
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
        String userId
) {

    public static Laptop fromInLaptopDtoToLaptop(inLaptopDto laptopDto) {
        Laptop laptop = new Laptop();
        laptop.setSerialNumber(laptopDto.serialNumber());
        laptop.setLaptopModel(laptopDto.laptopModel());
        laptop.setLaptopDate(laptopDto.laptopDate());
        laptop.setUrlImagen(laptopDto.urlImagen());
        laptop.setDescription(laptopDto.description());
        laptop.setPrecio(laptopDto.precio());
        laptop.setDescuento(laptopDto.descuento());
        laptop.setMarca(laptopDto.marca());
        laptop.setProcesador(laptopDto.procesador());
        laptop.setPantalla(laptopDto.pantalla());
        laptop.setDistribucionTeclado(laptopDto.distribucionTeclado());
        laptop.setAlmacenamiento(laptopDto.almacenamiento());
        laptop.setSistemaOperativo1(laptopDto.sistemaOperativo1());
        if (laptopDto.sistemaOperativo2() != null)
            laptop.setSistemaOperativo2(laptopDto.sistemaOperativo2());
        else
            laptop.setSistemaOperativo2(null);
        laptop.setMemoriaRam1(laptopDto.memoriaRam1());
        if (laptopDto.memoriaRam2() != null)
            laptop.setMemoriaRam2(laptopDto.memoriaRam2());
        else
            laptop.setMemoriaRam2(null);
        laptop.setTarjetaVideo(laptopDto.tarjetaVideo());
        laptop.setUserId(laptopDto.userId());
        return laptop;
    }
}
