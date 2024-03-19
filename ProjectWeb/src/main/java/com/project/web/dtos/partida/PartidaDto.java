package com.project.web.dtos.partida;

import com.project.web.dtos.usuario.UsuarioDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public record PartidaDto(
        Long id,
        String creador,
        String deporte,
        String ciudad,
        String provincia,
        LocalDate fecha,
        LocalTime hora_comienzo,
        LocalTime hora_final,
        Integer participantes,
        Integer suplentes,
        String comentarios,
        List<UsuarioDto> usuarios

) {

    public List<UsuarioDto> usuarios() {
        return Collections.unmodifiableList(usuarios);
    }

}
