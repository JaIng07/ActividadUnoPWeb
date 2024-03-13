package com.project.web.dtos.sugerencia;

import com.project.web.entities.Sugerencia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SugerenciaMapper {

    SugerenciaMapper INSTANCE = Mappers.getMapper( SugerenciaMapper.class );

    SugerenciaDto sugerenciaToSugerenciaDto(Sugerencia sugerencia);
    SugerenciaDto sugerenciaDtoToSugerencia(SugerenciaDto sugerenciaDto);
}
