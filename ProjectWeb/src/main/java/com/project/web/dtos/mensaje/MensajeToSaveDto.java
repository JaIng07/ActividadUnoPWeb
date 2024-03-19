package com.project.web.dtos.mensaje;

import java.time.LocalDate;

import com.project.web.dtos.usuario.UsuarioDto;

public record MensajeToSaveDto(
   Long id,
   String destinatario,
   String contenido,
   LocalDate create_at,
   UsuarioDto usuario
) {    
}
