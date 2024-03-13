package com.project.web.services;

import com.project.web.dtos.usuario.UsuarioDto;
import com.project.web.entities.Usuario;

public interface UsuarioService {
    UsuarioDto saveUsuario(Usuario usuario);
    UsuarioDto updateUsuario(Usuario usuario);
    //El resto de Querys que están en los Repository de cada entidad

}
