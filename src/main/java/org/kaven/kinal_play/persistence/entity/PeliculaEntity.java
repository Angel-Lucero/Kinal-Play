package org.kaven.kinal_play.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Peliculas")
@Data
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 150, unique = true, nullable = false)
    private String nombre;
    @Column(precision = 3, nullable = false)
    private Integer duracion;
    @Column(length = 40, nullable = false)
    private String genero;//varchar(40)
    @Column(name = "fecha_estreno")
    private LocalDate fechaEstreno;
    @Column(precision = 3, scale = 2)
    private BigDecimal calificacion;
    @Column(length = 1, nullable = false)
    private String estado;
}
