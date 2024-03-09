package com.project.web.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.junit.jupiter.api.Test;
import com.project.web.entities.Partida;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PartidaRepositoryTest {

    @Autowired
    private PartidaRepository partidaRepository;

    @Test
    public void PartidaRepositoryTest_SaveAll_ReturnSavedPlay(){
        Partida partida = Partida.builder()
                .creador("nelson")
                .deporte("futbol")
                .ciudad("Santa marta").build();

        @SuppressWarnings("null")
        Partida savedPlay = partidaRepository.save(partida);

        Assertions.assertThat(savedPlay).isNotNull();
        Assertions.assertThat(savedPlay.getCreador()).isEqualTo("nelson");
        Assertions.assertThat(savedPlay.getComentarios()).isNull();
    }

    @SuppressWarnings("null")
    @Test
    public void PartidaRepository_FindById_ReturnSavedSuggestion(){
        Partida partida = Partida.builder()
                .ciudad("Yopal")
                .fecha(LocalDate.now())
                .deporte("Patinaje")
                .build();

        partidaRepository.save(partida);

        Partida returnedSuggestion = partidaRepository.findById(partida.getId()).get();

        Assertions.assertThat(returnedSuggestion).isNotNull();
        Assertions.assertThat(returnedSuggestion.getCiudad()).isEqualTo("Yopal");
    }

    @SuppressWarnings("null")
    @Test
    public void PartidaRepositoryTest_GetAll_ReturnMoreThanOnePlay(){
        Partida partida1 = Partida.builder()
                .ciudad("Barranquilla")
                .deporte("basketball")
                .creador("julian").build();

        Partida partida2 = Partida.builder()
                .ciudad("Cartagena")
                .deporte("Voleibol")
                .creador("Carlos").build();;

        partidaRepository.save(partida1);
        partidaRepository.save(partida2);

        List<Partida> messagesList = partidaRepository.findAll();

        Assertions.assertThat(messagesList).isNotNull();
        Assertions.assertThat(messagesList.size()).isGreaterThan(0);
        Assertions.assertThat(messagesList.size()).isEqualTo(2);
    }

    @SuppressWarnings("null")
    @Test
    public void PartidaRepository_DeletePlay_ReturnPlayIsEmpty(){
        Partida partida = Partida.builder()
                .creador("javier")
                .comentarios("NINGUNO")
                .fecha(LocalDate.of(2024, 3, 8))
                .hora_comienzo(LocalTime.of(19, 30)).build();

        partidaRepository.save(partida);

        partidaRepository.deleteById(partida.getId());
        Optional<Partida> playReturned = partidaRepository.findById(partida.getId());

        Assertions.assertThat(playReturned).isEmpty();
    }

}