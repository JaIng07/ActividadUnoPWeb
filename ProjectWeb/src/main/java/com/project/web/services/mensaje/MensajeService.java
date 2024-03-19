package com.project.web.services.mensaje;

import java.time.LocalDate;

import com.project.web.dtos.mensaje.MensajeDto;
import com.project.web.dtos.mensaje.MensajeToSaveDto;
import com.project.web.exceptions.UsuarioNotFoundException;

public interface MensajeService {
    MensajeDto saveMensaje(MensajeToSaveDto mensaje);
    MensajeDto findByID(Long id) throws UsuarioNotFoundException;
    MensajeDto findByCreador(String creador);
    MensajeDto findByDestinatario(String destinatario) throws UsuarioNotFoundException;
    MensajeDto findByContenido(String contenido);
    MensajeDto findByCreadorOrContenido(String creador, String contenido) throws UsuarioNotFoundException;
    MensajeDto findByCreate_at(LocalDate create_at);
}
