package com.project.web.repositories;

import com.project.web.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    //Query Methods

    //Simples
    @SuppressWarnings("null")
    Optional<Mensaje> findById(Long id);
    
    List<Mensaje> findByCreador(String creador);
    List<Mensaje> findByDestinatario(String destinatario);
    List<Mensaje> findByContenido(String contenido);

    //Compuestos
    List<Mensaje> findByCreadorOrContenido(String creador, String contenido);

    //Personalizados

    @Query("SELECT m FROM Mensaje m WHERE m.create_at = ?1")
    List<Mensaje> findByCreate_at(LocalDate create_at);
}
