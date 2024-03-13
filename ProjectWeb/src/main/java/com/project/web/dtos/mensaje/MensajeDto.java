package com.project.web.dtos.mensaje;

import java.time.LocalDate;

public record MensajeDto(
        Long id,
        String creador,
        String destinatario,
        LocalDate create_at,
        String contenido
) {
}
