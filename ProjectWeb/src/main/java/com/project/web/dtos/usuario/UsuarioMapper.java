package com.project.web.dtos.usuario;

import com.project.web.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper( UsuarioMapper.class);

    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    UsuarioDto usuarioDtoToUsuario(UsuarioDto usuarioDto);
}
