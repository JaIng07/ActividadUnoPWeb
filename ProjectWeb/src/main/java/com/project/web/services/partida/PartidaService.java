package com.project.web.services.partida;

import com.project.web.dtos.partida.PartidaDto;
import com.project.web.dtos.partida.PartidaToSaveDto;
import com.project.web.entities.Partida;
import com.project.web.exceptions.PartidaNotFoundException;

import java.time.LocalDate;

public interface PartidaService {

    PartidaDto savePartida(PartidaToSaveDto partida);
    PartidaDto updatePartida(Partida partida);
    PartidaDto findById(Long id) throws PartidaNotFoundException;
    PartidaDto findByCreador(String creador) throws PartidaNotFoundException;
    PartidaDto findByDeporte(String deporte);
    PartidaDto findByCiudad(String ciudad);
    PartidaDto findByProvincia(String provincia);
    PartidaDto findByComentarios(String comentarios);
    PartidaDto findByCiudadOrProvincia(String ciudad, String provincia);
    PartidaDto findByFecha(LocalDate fecha) throws PartidaNotFoundException;
    PartidaDto findByParticipantes(Integer participantes);

}
