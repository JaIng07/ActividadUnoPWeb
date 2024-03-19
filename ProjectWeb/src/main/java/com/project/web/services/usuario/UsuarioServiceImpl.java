package com.project.web.services.usuario;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.project.web.dtos.usuario.UsuarioDto;
import com.project.web.dtos.usuario.UsuarioMapper;
import com.project.web.dtos.usuario.UsuarioToSaveDto;
import com.project.web.entities.Usuario;
import com.project.web.exceptions.UsuarioNotFoundException;
import com.project.web.repositories.UsuarioRepository;

import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @SuppressWarnings("null")
    @Override
    public UsuarioDto saveUsuario(UsuarioToSaveDto usuarioDto) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioSaveDtoToUsuarioEntity(usuarioDto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuarioGuardado);
    }
    
    @Override
    public UsuarioDto updateUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public UsuarioDto findById(Long id) throws UsuarioNotFoundException {
        Usuario usuario = usuarioRepository.findById(id)
        .orElseThrow(()-> new UsuarioNotFoundException("Usuario No Encontrado"));
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto findByNombre(String nombre) throws UsuarioNotFoundException {
        Usuario usuario = (Usuario) usuarioRepository.findByNombre(nombre);
        if(Objects.isNull(usuario))
            throw new UsuarioNotFoundException("Usuario no encontrado");
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto findByApellidos(String apellidos)  {
        Usuario usuario = (Usuario) usuarioRepository.findByApellidos(apellidos);
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto findByEdad(Integer edad){
        Usuario usuario = (Usuario) usuarioRepository.findByEdad(edad);
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto findByRol(String rol) {
        Usuario usuario = (Usuario) usuarioRepository.findByRol(rol);
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto findByNombreAndApellidos(String nombre, String apellidos) {
        Usuario usuario = (Usuario) usuarioRepository.findByNombreAndApellidos(nombre, apellidos);
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto findByUsernameAndRol(String username, String rol) throws UsuarioNotFoundException {
        Usuario usuario = (Usuario) usuarioRepository.findByUsernameAndRol(username, rol);
        if(Objects.isNull(usuario))
            throw new UsuarioNotFoundException("Usuario no encontrado");
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto findByNombreOrApellidos(String nombre, String apellidos) throws UsuarioNotFoundException {
        Usuario usuario = (Usuario) usuarioRepository.findByNombreOrApellidos(nombre, apellidos);
        if(Objects.isNull(usuario))
            throw new UsuarioNotFoundException("Usuario no encontrado");
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
        
    }

    @Override
    public UsuarioDto findByFoto(String foto) throws UsuarioNotFoundException {
        Usuario usuario = (Usuario) usuarioRepository.findByFoto(foto);
        if(Objects.isNull(usuario))
            throw new UsuarioNotFoundException("Usuario no encontrado");
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto findByEdadAfter(Integer edad) {
        Usuario usuario = (Usuario) usuarioRepository.findByEdadAfter(edad);
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto findByCreate_at(LocalDate create_at) throws UsuarioNotFoundException {
        Usuario usuario = (Usuario) usuarioRepository.findByCreate_at(create_at);
        if(Objects.isNull(usuario))
            throw new UsuarioNotFoundException("Usuario no encontrado");
        return UsuarioMapper.INSTANCE.usuarioEntityToUsuarioDto(usuario);
    }

}
