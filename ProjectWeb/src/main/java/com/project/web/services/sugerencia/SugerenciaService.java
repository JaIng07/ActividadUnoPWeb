package com.project.web.services.sugerencia;

import java.time.LocalDate;
import com.project.web.dtos.sugerencia.SugerenciaDto;

public interface SugerenciaService {
    SugerenciaDto findByDescripcion(String descripcion);
    SugerenciaDto findByCreate_At(LocalDate create_at);
}
