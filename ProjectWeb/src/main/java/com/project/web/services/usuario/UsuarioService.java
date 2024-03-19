package com.project.web.services.usuario;

import java.time.LocalDate;

import com.project.web.dtos.usuario.UsuarioDto;
import com.project.web.dtos.usuario.UsuarioToSaveDto;
import com.project.web.entities.Usuario;
import com.project.web.exceptions.UsuarioNotFoundException;

public interface UsuarioService {
    UsuarioDto saveUsuario(UsuarioToSaveDto usuario);
    UsuarioDto updateUsuario(Usuario usuario);
    UsuarioDto findById(Long id) throws UsuarioNotFoundException;
    UsuarioDto findByNombre(String nombre) throws UsuarioNotFoundException;
    UsuarioDto findByApellidos(String apellidos);
    UsuarioDto findByEdad(Integer edad);
    UsuarioDto findByRol(String rol);
    UsuarioDto findByNombreAndApellidos(String nombre, String apellidos);
    UsuarioDto findByUsernameAndRol(String username, String rol) throws UsuarioNotFoundException;
    UsuarioDto findByNombreOrApellidos(String nombre, String apellidos) throws UsuarioNotFoundException;
    UsuarioDto findByFoto(String foto) throws UsuarioNotFoundException;
    UsuarioDto findByEdadAfter(Integer edad);
    UsuarioDto findByCreate_at(LocalDate create_at) throws UsuarioNotFoundException;
}
