package com.project.web.dtos.partida;

import com.project.web.entities.Partida;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PartidaMapper {

    PartidaMapper INSTANCE = Mappers.getMapper( PartidaMapper.class );

    PartidaDto partidaEntityToPartidaDto(Partida partida);

    @InheritInverseConfiguration
    Partida partidaDtoToPartidaEntity(PartidaDto partidaDto);


    Partida partidaSaveDtoToPartidaEntity(PartidaToSaveDto partidaDto);

}
