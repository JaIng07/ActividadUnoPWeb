package com.project.web.dtos.usuario;

import com.project.web.dtos.mensaje.MensajeDto;
import com.project.web.dtos.sugerencia.SugerenciaDto;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public record UsuarioDto(
        Long id,
        String username,
        String email,
        String nombre,
        String apellidos,
        Integer edad,
        String password,
        String rep_password,
        Boolean enabled,
        String foto,
        String rol,
        LocalDate create_at,
        List<SugerenciaDto> sugerencias,
        List<MensajeDto> mensajes
) {
    public List<SugerenciaDto> sugerencias() {
        return Collections.unmodifiableList(sugerencias);
    }

    public List<MensajeDto> mensajes() {
        return Collections.unmodifiableList(mensajes);
    }
}
