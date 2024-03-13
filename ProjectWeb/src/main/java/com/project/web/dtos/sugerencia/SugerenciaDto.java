package com.project.web.dtos.sugerencia;

import java.time.LocalDate;

public record SugerenciaDto(
        Long id,
        String descripcion,
        LocalDate create_at
) {
}
