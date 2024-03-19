package com.project.web.services.mensaje;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.web.dtos.mensaje.MensajeDto;
import com.project.web.dtos.mensaje.MensajeMapper;
import com.project.web.dtos.mensaje.MensajeToSaveDto;
import com.project.web.entities.Mensaje;
import com.project.web.exceptions.UsuarioNotFoundException;
import com.project.web.repositories.MensajeRepository;

@Service
public class MensajeServiceImpl implements MensajeService{

    private final MensajeRepository mensajeRepository;

    public MensajeServiceImpl(MensajeRepository mensajeRepository){
        this.mensajeRepository = mensajeRepository;
    }

    @SuppressWarnings("null")
    @Override
    public MensajeDto saveMensaje(MensajeToSaveDto mensajeDto) {
        Mensaje mensaje = MensajeMapper.INSTANCE.mensajeSaveDtoToMensajeEntity(mensajeDto);
        Mensaje mensajeGuardado = mensajeRepository.save(mensaje);
        return MensajeMapper.INSTANCE.mensajeEntityToMensajeDto(mensajeGuardado);
    }

    @Override
    public MensajeDto findByID(Long id) throws UsuarioNotFoundException {
        Optional<Mensaje> mensaje = mensajeRepository.findById(id);
        if(Objects.isNull(mensaje))
            throw new UsuarioNotFoundException("Usuario no encontrado");
        return MensajeMapper.INSTANCE.ToMensajeDto(mensaje);
    }

    @Override
    public MensajeDto findByCreador(String creador) {
        Mensaje mensaje = (Mensaje) mensajeRepository.findByCreador(creador);
        return MensajeMapper.INSTANCE.mensajeEntityToMensajeDto(mensaje);
    }

    @Override
    public MensajeDto findByDestinatario(String destinatario) throws UsuarioNotFoundException {
        Mensaje mensaje = (Mensaje) mensajeRepository.findByDestinatario(destinatario);
        if(Objects.isNull(mensaje))
            throw new UsuarioNotFoundException("Usuario no encontrado");
        return MensajeMapper.INSTANCE.mensajeEntityToMensajeDto(mensaje);
    }

    @Override
    public MensajeDto findByContenido(String contenido) {
        Mensaje mensaje = (Mensaje) mensajeRepository.findByContenido(contenido);
        return MensajeMapper.INSTANCE.mensajeEntityToMensajeDto(mensaje);
    }

    @Override
    public MensajeDto findByCreadorOrContenido(String creador, String contenido) throws UsuarioNotFoundException {
        Mensaje mensaje = (Mensaje) mensajeRepository.findByCreadorOrContenido(creador, contenido);
        if(Objects.isNull(mensaje))
            throw new UsuarioNotFoundException("Usuario no encontrado");
        return MensajeMapper.INSTANCE.mensajeEntityToMensajeDto(mensaje);
    }

    @Override
    public MensajeDto findByCreate_at(LocalDate create_at) {
        Mensaje mensaje = (Mensaje) mensajeRepository.findByCreate_at(create_at);
        return MensajeMapper.INSTANCE.mensajeEntityToMensajeDto(mensaje);
    }
    
}
