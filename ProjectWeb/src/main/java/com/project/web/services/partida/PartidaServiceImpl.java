package com.project.web.services.partida;

import com.project.web.dtos.partida.PartidaDto;
import com.project.web.dtos.partida.PartidaMapper;
import com.project.web.dtos.partida.PartidaToSaveDto;
import com.project.web.entities.Partida;
import com.project.web.exceptions.PartidaNotFoundException;
import com.project.web.repositories.PartidaRepository;

import java.time.LocalDate;
import java.util.Objects;

public class PartidaServiceImpl implements PartidaService {

    private final PartidaRepository partidaRepository;

    public PartidaServiceImpl(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    @Override
    public PartidaDto savePartida(PartidaToSaveDto partidaDto) {
        Partida partida = PartidaMapper.INSTANCE.partidaSaveDtoToPartidaEntity(partidaDto);
        Partida partidaGuardada = partidaRepository.save(partida);
        return PartidaMapper.INSTANCE.partidaEntityToPartidaDto(partidaGuardada);
    }

    @Override
    public PartidaDto updatePartida(Partida partida) {
        return null;
    }

    @Override
    public PartidaDto findById(Long id) throws PartidaNotFoundException {
        Partida partida = partidaRepository.findById(id)
        .orElseThrow(()-> new PartidaNotFoundException("Partida No Encontrada"));
        return PartidaMapper.INSTANCE.partidaEntityToPartidaDto(partida);
    }

    @Override
    public PartidaDto findByCreador(String creador) throws PartidaNotFoundException {
        Partida partida = (Partida) partidaRepository.findByCreador(creador);
        if(Objects.isNull(partida))
            throw new PartidaNotFoundException("Partida no encontrada");
        return PartidaMapper.INSTANCE.partidaEntityToPartidaDto(partida);
    }

    @Override
    public PartidaDto findByDeporte(String deporte) {
        Partida partida = (Partida) partidaRepository.findByDeporte(deporte);
        return PartidaMapper.INSTANCE.partidaEntityToPartidaDto(partida);
    }

    @Override
    public PartidaDto findByCiudad(String ciudad) {
        Partida partida = (Partida) partidaRepository.findByCiudad(ciudad);
        return PartidaMapper.INSTANCE.partidaEntityToPartidaDto(partida);
    }

    @Override
    public PartidaDto findByProvincia(String provincia) {
        Partida partida = (Partida) partidaRepository.findByProvincia(provincia);
        return PartidaMapper.INSTANCE.partidaEntityToPartidaDto(partida);
    }

    @Override
    public PartidaDto findByComentarios(String comentarios) {
        Partida partida = (Partida) partidaRepository.findByComentarios(comentarios);
        return PartidaMapper.INSTANCE.partidaEntityToPartidaDto(partida);
    }

    @Override
    public PartidaDto findByCiudadOrProvincia(String ciudad, String provincia) {
        Partida partida = (Partida) partidaRepository.findByCiudadOrProvincia(ciudad, provincia);
        return PartidaMapper.INSTANCE.partidaEntityToPartidaDto(partida);
    }

    @Override
    public PartidaDto findByFecha(LocalDate fecha) throws PartidaNotFoundException {
        Partida partida = (Partida) partidaRepository.findByFecha(fecha);
        if(Objects.isNull(partida))
            throw new PartidaNotFoundException("Partida no encontrada");
        return PartidaMapper.INSTANCE.partidaEntityToPartidaDto(partida);
    }

    @Override
    public PartidaDto findByParticipantes(Integer participantes) {
        Partida partida = (Partida) partidaRepository.findByParticipantes(participantes);
        return PartidaMapper.INSTANCE.partidaEntityToPartidaDto(partida);
    }
}
