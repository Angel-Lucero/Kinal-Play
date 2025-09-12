package org.kaven.kinal_play.dominio.service;

import org.kaven.kinal_play.dominio.Genre;
import org.kaven.kinal_play.dominio.dto.ModPeliculaDto;
import org.kaven.kinal_play.dominio.dto.PeliculaDto;
import org.kaven.kinal_play.dominio.exception.GeneroNoExisteException;
import org.kaven.kinal_play.dominio.exception.RangoCalificacionInvalidoException;
import org.kaven.kinal_play.dominio.exception.TiempoDuracionInvalidoException;
import org.kaven.kinal_play.dominio.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
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
        validarCalificacion(BigDecimal.valueOf(peliculaDto.rating()));
        validarDuracion(peliculaDto.duration());
        validarGenero(peliculaDto.genre());
        return this.peliculaRepository.guardarPelicula(peliculaDto);
    }

    public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modpeliculaDto){
        if (modpeliculaDto.rating() != null) {
            validarCalificacion(BigDecimal.valueOf(modpeliculaDto.rating()));
        }
        return this.peliculaRepository.modificarPelicula(codigo, modpeliculaDto);
    }

    public void eliminarPelicula(Long codigo){
        this.peliculaRepository.eliminarPelicula(codigo);
    }

    private void validarCalificacion(BigDecimal calificacion) {
        if (calificacion != null) {
            if (calificacion.compareTo(BigDecimal.ZERO) < 0 || calificacion.compareTo(BigDecimal.TEN) > 0) {
                throw new RangoCalificacionInvalidoException(calificacion);
            }
        }
    }

    private void validarDuracion(Integer duracion) {
        if (duracion != null) {
            if (duracion <= 0) {
                throw new TiempoDuracionInvalidoException(duracion);
            }
        }
    }

    private void validarGenero(Genre genre) {
        if (genre != null) {
            if (!Arrays.asList(Genre.values()).contains(genre)) {
                throw new GeneroNoExisteException(genre.name());
            }
        }
    }
}
