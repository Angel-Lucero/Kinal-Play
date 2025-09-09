package org.kaven.kinal_play.web.mapper;

import org.kaven.kinal_play.dominio.dto.PeliculaDto;
import org.kaven.kinal_play.persistence.entity.PeliculaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring", uses = {GenreMapper.class})
public interface PeliculaMapper {
    //firmas de metodos toDto -> convertir a DTO
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "generarGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "calificacion", target = "rating")
    PeliculaDto toDto(PeliculaEntity entity);
    List<PeliculaDto> toDto(Iterable<PeliculaEntity> entities);
    //Para convertir Dto -> Entity - toEntity

    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genero", qualifiedByName = "generarGenero")
    PeliculaEntity toEntity(PeliculaDto peliculaDto);

}
