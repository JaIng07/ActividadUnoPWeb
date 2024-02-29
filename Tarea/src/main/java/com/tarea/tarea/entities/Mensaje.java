package com.tarea.tarea.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Mensajes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Creador")
    private String creador;

    @Column(name = "Destinatario")
    private String destinatario;

    @Column(name = "CreateAt")
    private LocalDate create_at;

    @Column(name = "Contenido")
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private Usuario usuario;

}
