package com.masBarato.masBarato.infrastructure.dataBase.sql.entity;


import com.masBarato.masBarato.domain.model.TecnologiaPantalla;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="pantalla")
public class PantallaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pantalla")
    private Integer idPantalla;
    @Column(name = "ancho_pantalla")
    private double anchoPantalla;
    @Column(name = "altura_pantalla")
    private double altoPantalla;
    @Enumerated(EnumType.STRING)
    @Column(name = "tecnologia_pantalla", nullable = false)
    private TecnologiaPantalla tecnologiaPantalla;
    @Column(name = "es_tactil")
    private boolean esTactil;
}
