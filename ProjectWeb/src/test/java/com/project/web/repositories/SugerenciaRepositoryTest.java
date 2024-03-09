package com.project.web.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.project.web.entities.Sugerencia;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SugerenciaRepositoryTest {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    @SuppressWarnings("null")
    @Test
    public void SugerenciaRepositoryTest_FindByDescription_ReturnIsEqualTo(){
        Sugerencia sugerencia = Sugerencia.builder()
                .create_at(LocalDate.now())
                .descripcion("Make your website faster dude.")
                .build();

        sugerenciaRepository.save(sugerencia);

        Sugerencia returnedSuggestion = sugerenciaRepository.findByDescripcion(sugerencia.getDescripcion()).get(0);

        Assertions.assertThat(returnedSuggestion).isNotNull();
        Assertions.assertThat(returnedSuggestion.getDescripcion()).isEqualTo("Make your website faster dude.");
    }

    @SuppressWarnings("null")
    @Test
    public void SugerenciaRepository_FindAll_ReturnMoreThanOneSuggestion(){
        Sugerencia suggestionOne = Sugerencia.builder()
                .create_at(LocalDate.now())
                .descripcion("Should improve Front-End")
                .build();

        Sugerencia suggestionTwo = Sugerencia.builder()
                .create_at(LocalDate.now())
                .descripcion("Add a loyal or field for custome service please. It's necesary")
                .build();

        sugerenciaRepository.save(suggestionOne);
        sugerenciaRepository.save(suggestionTwo);

        List<Sugerencia> suggestionsList = sugerenciaRepository.findAll();

        Assertions.assertThat(suggestionsList).isNotNull();
        Assertions.assertThat(suggestionsList.size()).isGreaterThan(1);
        Assertions.assertThat(suggestionsList.size()).isEqualTo(2);
    }

}