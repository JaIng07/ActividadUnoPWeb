package com.tarea.tarea.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Sugerencias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Sugerencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "CreateAt")
    private LocalDate create_at;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private Usuario usuario;

}
