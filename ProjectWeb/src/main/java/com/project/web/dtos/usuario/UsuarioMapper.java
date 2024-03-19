package com.project.web.dtos.usuario;

import com.project.web.entities.Usuario;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper( UsuarioMapper.class);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "edad", target = "edad")
    })
    UsuarioDto usuarioEntityToUsuarioDto(Usuario usuario);

    @InheritInverseConfiguration
    Usuario usuarioDtoToUsuarioEntity(UsuarioDto usuarioDto);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "apellido", target = "apellidos")
    })
    Usuario usuarioSaveDtoToUsuarioEntity(UsuarioToSaveDto usuarioDto);
}
