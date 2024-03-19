package com.project.web.dtos.partida;

import java.time.LocalDate;
import java.time.LocalTime;

public record PartidaToSaveDto(
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
        String comentarios
) {
}
