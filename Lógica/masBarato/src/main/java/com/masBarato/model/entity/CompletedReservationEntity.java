package com.masBarato.masBarato.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

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
    private Date creationDate;

    @Column(name = "fecha_recogida")
    private Date pickupDate;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "username")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "fk_laptop", referencedColumnName = "serial_number")
    private LaptopEntity laptop;
}