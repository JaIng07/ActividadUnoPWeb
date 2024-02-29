package com.tarea.tarea.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Email")
    private String email;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "Edad")
    private Integer edad;

    @Column(name = "Password")
    private String password;

    @Column(name = "RepPassword")
    private String rep_password;

    @Column(name = "Enabled")
    private Boolean enabled;

    @Column(name = "Foto")
    private String foto;

    @Column(name = "Rol")
    private String rol;

    @Column(name = "CreateAt")
    private LocalDate create_at;

    @OneToMany(mappedBy = "usuario")
    private List<Sugerencia> sugerencias;

    @OneToMany(mappedBy = "usuario")
    private List<Mensaje> mensajes;

    @ManyToMany
    @JoinTable(name = "partidas_usuarios",
            joinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idPartida", referencedColumnName = "id"))
    List<Partida> partidas;

}
