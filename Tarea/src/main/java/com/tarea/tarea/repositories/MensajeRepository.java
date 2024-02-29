package com.tarea.tarea.repositories;

import com.tarea.tarea.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    //Query Methods

    //Simples
    List<Mensaje> findByCreador(String creador);
    List<Mensaje> findByDestinatario(String destinatario);
    List<Mensaje> findByContenido(String contenido);

    //Compuestos
    List<Mensaje> findByCreadorOrContenido(String creador, String contenido);

    //Personalizados

    @Query("SELECT m FROM Mensaje m WHERE m.create_at = ?1")
    List<Mensaje> findByCreate_at(LocalDate create_at);
}
