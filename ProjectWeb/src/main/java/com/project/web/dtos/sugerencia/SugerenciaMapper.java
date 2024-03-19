package com.project.web.dtos.sugerencia;

import com.project.web.entities.Sugerencia;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SugerenciaMapper {

    SugerenciaMapper INSTANCE = Mappers.getMapper( SugerenciaMapper.class );

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "descripcion", target = "descripcion"),
        @Mapping(source = "create_at", target = "create_at")
    })
    SugerenciaDto sugerenciaEntityToSugerenciaDto(Sugerencia sugerencia);

    @InheritInverseConfiguration
    Sugerencia sugerenciaDtoToSugerenciaEntity(SugerenciaDto sugerenciaDto);
}
