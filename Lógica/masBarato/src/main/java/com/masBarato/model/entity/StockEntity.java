package com.masBarato.masBarato.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stock")
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock")
    private Integer stockId;

    @Column(name = "aumento")
    private Boolean increase;

    @Column(name = "cantidad")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "username")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "fk_laptop", referencedColumnName = "numero_serie")
    private LaptopEntity laptop;
}