package com.masBarato.masBarato.infrastructure.dataBase.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reservacion_completada")
public class CompletedReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservacion")
    private Integer reservationId;

    @Column(name = "mensajeria")
    private Boolean messaging;

    @Column(name = "precio_mensajeria")
    private Float messagingPrice;

    @Column(name = "fecha_creacion")
    private String creationDate;

    @Column(name = "fecha_recogida")
    private String pickupDate;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "fk_laptop", referencedColumnName = "id_laptop")
    private LaptopEntity laptop;
}