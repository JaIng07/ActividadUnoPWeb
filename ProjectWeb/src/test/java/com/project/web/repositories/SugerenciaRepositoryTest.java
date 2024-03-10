package com.project.web.repositories;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.web.AbstractIntegrationDBTest;
import com.project.web.entities.Sugerencia;

public class SugerenciaRepositoryTest extends AbstractIntegrationDBTest {

    private SugerenciaRepository sugerenciaRepository;

    @Autowired
    public SugerenciaRepositoryTest (SugerenciaRepository sugerenciaRepository){
        this.sugerenciaRepository = sugerenciaRepository;
    }

    @BeforeEach
    void setUp(){
        sugerenciaRepository.deleteAll();
    }

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