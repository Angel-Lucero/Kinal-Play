package org.kaven.kinal_play.dominio.service;

import org.kaven.kinal_play.dominio.dto.ModPeliculaDto;
import org.kaven.kinal_play.dominio.dto.PeliculaDto;
import org.kaven.kinal_play.dominio.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List <PeliculaDto> obtenerTodo(){
        return this.peliculaRepository.obtnerTodo();
    }

    public PeliculaDto obtenerPeliculaPorCodigo(Long codigo){
        return this.peliculaRepository.obtenerPeliculaPorCodigo(codigo);
    }

    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto){
        return this.peliculaRepository.guardarPelicula(peliculaDto);
    }

    public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modpeliculaDto){
        return this.peliculaRepository.modificarPelicula(codigo, modpeliculaDto);
    }
}
