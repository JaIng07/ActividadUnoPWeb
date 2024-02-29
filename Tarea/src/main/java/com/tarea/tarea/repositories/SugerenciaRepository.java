package com.tarea.tarea.repositories;

import com.tarea.tarea.entities.Sugerencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SugerenciaRepository extends JpaRepository<Sugerencia, Long> {

    //Query Methods

    //Simples
    List<Sugerencia> findByDescripcion(String descripcion);

    //Personalizados
    @Query("SELECT s FROM Sugerencia s WHERE s.create_at = ?1")
    List<Sugerencia> findByCreate_At(LocalDate create_at);
}
