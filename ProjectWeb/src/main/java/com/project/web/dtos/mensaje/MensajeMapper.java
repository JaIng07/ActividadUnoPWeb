package com.project.web.dtos.mensaje;

import com.project.web.entities.Mensaje;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MensajeMapper {

    MensajeMapper INSTANCE = Mappers.getMapper( MensajeMapper.class);

    MensajeDto mensajeToMensajeDto(Mensaje mensaje);
    MensajeDto mensajeDtoToMensaje(MensajeDto mensajeDto);
}
