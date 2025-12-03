package com.masBarato.masBarato.infrastructure.dataBase.sql.entity;


import com.masBarato.masBarato.domain.model.TipoAlmacenamiento;
import com.masBarato.masBarato.domain.model.UnidadMedida;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="almacenamiento")

public class AlmacenamientoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_almacenamiento")
    private Integer idAlmacenamiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_tipo_almacenamiento", nullable = false)
    private TipoAlmacenamiento nombreTipoAlmacenamiento;

    @Column(name = "tamannio_almacenamiento", nullable = false)
    private Integer tamanioAlmacenamiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "unidad_medida_tamannio_almacenamiento", nullable = false)
    private UnidadMedida unidadMedidaTamanioAlmacenamiento;

}
