package com.tarea.tarea.repositories;

import com.tarea.tarea.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    //Query Methods

    //Simples
    List<Partida> findByCreador(String creador);
    List<Partida> findByDeporte(String deporte);
    List<Partida> findByCiudad(String ciudad);
    List<Partida> findByProvincia(String provincia);
    List<Partida> findByComentarios(String comentarios);

    //Compuestas
    List<Partida> findByCiudadOrProvincia(String ciudad, String provincia);

    //Personalizados

    //Encontrar partida por fecha
    @Query("SELECT p FROM Partida p WHERE p.fecha = ?1")
    List<Partida> findByFecha(LocalDate fecha);

    //Encontrar partida por cantidad de participantes
    @Query("SELECT p FROM Partida p WHERE p.participantes = ?1")
    List<Partida> findByParticipantes(Integer participantes);
}
