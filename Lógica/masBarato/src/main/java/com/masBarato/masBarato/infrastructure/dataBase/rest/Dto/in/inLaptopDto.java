package com.masBarato.masBarato.infrastructure.dataBase.rest.Dto.in;

import com.masBarato.masBarato.domain.model.Laptop;

import java.util.Date;

public record inLaptopDto(
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

    public static Laptop fromInLaptopDtoToLaptop(inLaptopDto laptopDto) {
        Laptop laptop = new Laptop();
        laptop.setLaptopId(laptopDto.laptopId());
        laptop.setLaptopModel(laptopDto.laptopModel());
        laptop.setLaptopDate(laptopDto.laptopDate());
        laptop.setUrlImagen(laptopDto.urlImagen());
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
