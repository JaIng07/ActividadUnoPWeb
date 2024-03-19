package com.project.web.dtos.mensaje;

import com.project.web.entities.Mensaje;

import java.util.Optional;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MensajeMapper {

    MensajeMapper INSTANCE = Mappers.getMapper( MensajeMapper.class);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "destinatario", target = "destinatario"),
        @Mapping(source = "create_at", target = "create_at")
    })
    MensajeDto mensajeEntityToMensajeDto(Mensaje mensaje);

    @InheritInverseConfiguration
    Mensaje mensajeDtoToMensajeEntity(MensajeDto mensajeDto);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "destinatario", target = "destinatario"),
        @Mapping(source = "create_at", target = "create_at")
    })
    Mensaje mensajeSaveDtoToMensajeEntity(MensajeToSaveDto mensajeDto);

    /*@Mappings({
        @Mapping(source = "idMensaje", target = "id"),
        @Mapping(source = "destinatario", target = "destinatario"),
        @Mapping(source = "create_at", target = "create_at")
    })*/
    MensajeDto ToMensajeDto(Optional<Mensaje> mensaje);
}
