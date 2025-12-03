package com.masBarato.masBarato.infrastructure.dataBase.sql.mapper;

import com.masBarato.masBarato.domain.model.Laptop;
import com.masBarato.masBarato.infrastructure.dataBase.sql.entity.*;

import java.sql.Date;
import java.util.List;

public class LaptopMapper {
    public static Laptop fromLaptopEntityToLaptop(LaptopEntity laptopEntities) {
        if (laptopEntities == null) {
            return null;
        }
        Laptop laptop = new Laptop();
        laptop.setLaptopId(laptopEntities.getIdLaptop());
        laptop.setLaptopModel(laptopEntities.getModelo());
        laptop.setLaptopDate(laptopEntities.getFechaCreacion());
        laptop.setUrlImagen(laptopEntities.getUrlImagen());
        laptop.setMarca(laptopEntities.getMarca().getIdMarca());
        laptop.setProcesador(laptopEntities.getProcesador().getIdProcesador());
        laptop.setPantalla(laptopEntities.getPantalla().getIdPantalla());
        laptop.setDistribucionTeclado(laptopEntities.getDistribucionTeclado().getId());
        laptop.setAlmacenamiento(laptopEntities.getAlmacenamiento().getIdAlmacenamiento());
        laptop.setSistemaOperativo1(laptopEntities.getSistemaOperativo1().getIdSO());
        if (laptopEntities.getSistemaOperativo2() != null)
            laptop.setSistemaOperativo2(laptopEntities.getSistemaOperativo2().getIdSO());
        else
            laptop.setSistemaOperativo2(null);
        laptop.setMemoriaRam1(laptopEntities.getMemoriaRam1().getIdMemoria());
        if (laptopEntities.getMemoriaRam2() != null)
            laptop.setMemoriaRam2(laptopEntities.getMemoriaRam2().getIdMemoria());
        else
            laptop.setMemoriaRam2(null);
        laptop.setTarjetaVideo(laptopEntities.getTarjetaVideo().getIdTarjetaVideo());
        laptop.setUserId(laptopEntities.getUsuario().getUserId());

        return laptop;
    }

    public static LaptopEntity fromLaptopToLaptopEntity(Laptop laptop) {
        if (laptop == null) {
            return null;
        }
        LaptopEntity laptopEntity = new LaptopEntity();
        laptopEntity.setIdLaptop(laptop.getLaptopId());
        laptopEntity.setModelo(laptop.getLaptopModel());
        laptopEntity.setFechaCreacion(
                laptop.getLaptopDate() == null
                        ? null
                        : new java.sql.Date(laptop.getLaptopDate().getTime())
        );
        laptopEntity.setUrlImagen(laptop.getUrlImagen());
        MarcaEntity marcaEntity = new MarcaEntity();
        marcaEntity.setIdMarca(laptop.getMarca());
        laptopEntity.setMarca(marcaEntity);
        ProcesadorEntity procesadorEntity = new ProcesadorEntity();
        procesadorEntity.setIdProcesador(laptop.getProcesador());
        laptopEntity.setProcesador(procesadorEntity);
        PantallaEntity pantallaEntity = new PantallaEntity();
        pantallaEntity.setIdPantalla(laptop.getPantalla());
        laptopEntity.setPantalla(pantallaEntity);
        DistribucionTecladoEntity distribucionTecladoEntity = new DistribucionTecladoEntity();
        distribucionTecladoEntity.setId(laptop.getDistribucionTeclado());
        laptopEntity.setDistribucionTeclado(distribucionTecladoEntity);
        AlmacenamientoEntity almacenamientoEntity = new AlmacenamientoEntity();
        almacenamientoEntity.setIdAlmacenamiento(laptop.getAlmacenamiento());
        laptopEntity.setAlmacenamiento(almacenamientoEntity);
        SistemaOperativoEntity sistemaOperativoEntity1 = new SistemaOperativoEntity();
        sistemaOperativoEntity1.setIdSO(laptop.getSistemaOperativo1());
        laptopEntity.setSistemaOperativo1(sistemaOperativoEntity1);
        if (laptop.getSistemaOperativo2() != null){
            SistemaOperativoEntity sistemaOperativoEntity2 = new SistemaOperativoEntity();
            sistemaOperativoEntity2.setIdSO(laptop.getSistemaOperativo2());
            laptopEntity.setSistemaOperativo2(sistemaOperativoEntity2);
        }
        else {
            laptopEntity.setSistemaOperativo2(null);
        }
        MemoriaRamEntity memoriaRamEntity1 = new MemoriaRamEntity();
        memoriaRamEntity1.setIdMemoria(laptop.getMemoriaRam1());
        laptopEntity.setMemoriaRam1(memoriaRamEntity1);
        if (laptop.getMemoriaRam2() != null){
            MemoriaRamEntity memoriaRamEntity2 = new MemoriaRamEntity();
            memoriaRamEntity2.setIdMemoria(laptop.getMemoriaRam2());
            laptopEntity.setMemoriaRam2(memoriaRamEntity2);
        }
        else {
            laptopEntity.setMemoriaRam2(null);
        }
        TarjetaVideoEntity tarjetaVideoEntity = new TarjetaVideoEntity();
        tarjetaVideoEntity.setIdTarjetaVideo(laptop.getTarjetaVideo());
        laptopEntity.setTarjetaVideo(tarjetaVideoEntity);
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(laptop.getUserId());
        laptopEntity.setUsuario(userEntity);

        return laptopEntity;
    }
}
