package org.kaven.kinal_play.dominio.repository;

import org.kaven.kinal_play.dominio.dto.PeliculaDto;

import java.util.List;

public interface PeliculaRepository {
    //Firmas del mantenimiento de DTO
    List<PeliculaDto> obtnerTodo();
    PeliculaDto obtenerPeliculaPorCodigo(Long codigo);
}
