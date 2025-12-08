package com.masBarato.masBarato.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name ="laptop")
public class LaptopEntity {
    @Id
    @Column(name = "numero_serie")
    private String serialNumber;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "precio")
    private Float precio;

    @Column(name = "descuento")
    private Float descuento;

    @ManyToOne
    @JoinColumn(name = "fk_marca")
    private MarcaEntity marca;

    @ManyToOne
    @JoinColumn(name = "fk_procesador")
    private ProcesadorEntity procesador;

    @ManyToOne
    @JoinColumn(name = "fk_pantalla")
    private PantallaEntity pantalla;

    @ManyToOne
    @JoinColumn(name = "fk_distribucion_teclado")
    private DistribucionTecladoEntity distribucionTeclado;

    @ManyToOne
    @JoinColumn(name = "fk_almacenamiento")
    private AlmacenamientoEntity almacenamiento;

    @ManyToOne
    @JoinColumn(name = "fk_sistema_operativo_1")
    private SistemaOperativoEntity sistemaOperativo1;

    @ManyToOne
    @JoinColumn(name = "fk_sistema_operativo_2")
    private SistemaOperativoEntity sistemaOperativo2;

    @ManyToOne
    @JoinColumn(name = "fk_memoria_ram_1")
    private MemoriaRamEntity memoriaRam1;

    @ManyToOne
    @JoinColumn(name = "fk_memoria_ram_2")
    private MemoriaRamEntity memoriaRam2;

    @ManyToOne
    @JoinColumn(name = "fk_tarjeta_video")
    private TarjetaVideoEntity tarjetaVideo;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private UserEntity usuario;
}
