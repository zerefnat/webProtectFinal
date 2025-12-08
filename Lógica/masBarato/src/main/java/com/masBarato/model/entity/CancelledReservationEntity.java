package com.masBarato.masBarato.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "reservacion_cancelada")
public class CancelledReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservacion")
    private Integer reservationId;

    @Column(name = "mensajeria")
    private Boolean messaging;

    @Column(name = "precio_mensajeria")
    private Float messagingPrice;

    private Date creationDate;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "username")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "fk_laptop", referencedColumnName = "numero_serie")
    private LaptopEntity laptop;

}