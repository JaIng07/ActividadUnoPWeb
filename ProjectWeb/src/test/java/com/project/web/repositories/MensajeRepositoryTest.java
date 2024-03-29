package com.project.web.repositories;

import java.util.List;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.web.AbstractIntegrationDBTest;
import com.project.web.entities.Mensaje;

public class MensajeRepositoryTest extends AbstractIntegrationDBTest {

    private MensajeRepository mensajeRepository;

    @Autowired
    public MensajeRepositoryTest (MensajeRepository mensajeRepository){
        this.mensajeRepository = mensajeRepository;
    }

    @BeforeEach
    void setUp(){
        mensajeRepository.deleteAll();
    }

    @Test
    public void MensajeRepositoryTest_SaveAll_ReturnSavedMessages(){
        Mensaje mensaje = Mensaje.builder()
                .contenido("Hola")
                .creador("nelson")
                .build();

        @SuppressWarnings("null")
        Mensaje savedMessage = mensajeRepository.save(mensaje);

        Assertions.assertThat(savedMessage).isNotNull();
        Assertions.assertThat(savedMessage.getId()).isGreaterThan(0);
    }

    @SuppressWarnings("null")
    @Test
    public void MensajeRepositoryTest_GetAll_ReturnMoreThanOneMessage(){
        Mensaje mensaje1 = Mensaje.builder()
                .contenido("Hello World")
                .creador("javier")
                .build();

        Mensaje mensaje2 = Mensaje.builder()
                .contenido("Waht up?")
                .creador("julian")
                .build();

        mensajeRepository.save(mensaje1);
        mensajeRepository.save(mensaje2);

        List<Mensaje> messagesList = mensajeRepository.findAll();

        Assertions.assertThat(messagesList).isNotNull();
        Assertions.assertThat(messagesList.size()).isEqualTo(2);
    }

    @SuppressWarnings("null")
    @Test
    public void MensajeRepositoryTest_FindById_ReturnSavedMessage(){
        Mensaje mensaje = Mensaje.builder()
                .contenido("Hello World")
                .creador("javier")
                .build();

        mensajeRepository.save(mensaje);

        Mensaje returnedMensaje = mensajeRepository.findById(mensaje.getId()).get();

        Assertions.assertThat(returnedMensaje).isNotNull();
        Assertions.assertThat(returnedMensaje.getContenido()).isEqualTo("Hello World");
    }

    @SuppressWarnings("null")
    @Test
    public void MensajeRepositoryTest_DeletedMessage_ReturnMessageIsempty(){
        Mensaje mensaje = Mensaje.builder()
                .creador("Me")
                .destinatario("Them")
                .contenido("Making sure if i'ts you, answer if that's right")
                .build();

        mensajeRepository.save(mensaje);

        mensajeRepository.deleteById(mensaje.getId());
        Optional<Mensaje> returnedMessage = mensajeRepository.findById(mensaje.getId());

        Assertions.assertThat(returnedMessage).isEmpty();
    }

}