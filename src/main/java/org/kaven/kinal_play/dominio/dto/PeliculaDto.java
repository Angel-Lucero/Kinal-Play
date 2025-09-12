package org.kaven.kinal_play.dominio.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.kaven.kinal_play.dominio.Genre;

import java.time.LocalDate;

public record PeliculaDto(
        Long codigo,
        String name,
        Integer duration,
        //@JsonDeserialize(using = GenreDeserializer.class) ver esto despues aaaaaa
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        Boolean status
) {
}
