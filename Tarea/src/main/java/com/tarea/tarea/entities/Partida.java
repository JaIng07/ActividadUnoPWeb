package com.tarea.tarea.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Partidas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Creador")
    private String creador;

    @Column(name = "Deporte")
    private String deporte;

    @Column(name = "Ciudad")
    private String ciudad;

    @Column(name = "Provincia")
    private String provincia;

    @Column(name = "Fecha")
    private LocalDate fecha;

    @Column(name = "HoraComienzo")
    private LocalTime hora_comienzo;

    @Column(name = "HoraFinal")
    private LocalTime hora_final;

    @Column(name = "Participantes")
    private Integer participantes;

    @Column(name = "Suplentes")
    private Integer suplentes;

    @Column(name = "Comentarios")
    private String comentarios;

    @ManyToMany(mappedBy = "partidas")
    List<Usuario> usuarios;

}
