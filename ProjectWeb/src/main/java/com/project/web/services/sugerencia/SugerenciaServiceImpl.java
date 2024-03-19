package com.project.web.services.sugerencia;

import java.time.LocalDate;

import com.project.web.dtos.sugerencia.SugerenciaDto;
import com.project.web.dtos.sugerencia.SugerenciaMapper;
import com.project.web.entities.Sugerencia;
import com.project.web.repositories.SugerenciaRepository;
import org.springframework.stereotype.Service;

@Service
public class SugerenciaServiceImpl implements SugerenciaService{

    private final SugerenciaRepository sugerenciaRepository;

    public SugerenciaServiceImpl(SugerenciaRepository sugerenciaRepository){
        this.sugerenciaRepository = sugerenciaRepository;
    }

    @Override
    public SugerenciaDto findByDescripcion(String descripcion) {
        Sugerencia sugerencia = (Sugerencia) sugerenciaRepository.findByDescripcion(descripcion);
        return SugerenciaMapper.INSTANCE.sugerenciaEntityToSugerenciaDto(sugerencia);
    }

    @Override
    public SugerenciaDto findByCreate_At(LocalDate create_at) {
        Sugerencia sugerencia = (Sugerencia) sugerenciaRepository.findByCreate_At(create_at);
        return SugerenciaMapper.INSTANCE.sugerenciaEntityToSugerenciaDto(sugerencia);
    }
    
}
