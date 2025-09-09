package org.kaven.kinal_play.dominio.dto;

import org.kaven.kinal_play.dominio.Genre;

import java.time.LocalDate;

public record PeliculaDto(
        String name,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating
) {
}
