package com.masBarato.masBarato.mapper;

import com.masBarato.masBarato.model.classes.Marca;
import com.masBarato.masBarato.model.classes.Pantalla;
import com.masBarato.masBarato.model.entity.MarcaEntity;
import com.masBarato.masBarato.model.entity.PantallaEntity;

public class PantallaMapper {
    public static Pantalla fromMPantallaEntityToPantalla(PantallaEntity marcaEntity) {
        return new Pantalla(
        marcaEntity.getIdPantalla(),
        marcaEntity.getAnchoPantalla(),
        marcaEntity.getAltoPantalla(),
        marcaEntity.getTecnologiaPantalla(),
        marcaEntity.isEsTactil()
        );
    }
}
