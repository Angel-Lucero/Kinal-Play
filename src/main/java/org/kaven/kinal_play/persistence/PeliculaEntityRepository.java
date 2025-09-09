package org.kaven.kinal_play.persistence;

import org.kaven.kinal_play.dominio.dto.ModPeliculaDto;
import org.kaven.kinal_play.dominio.dto.PeliculaDto;
import org.kaven.kinal_play.dominio.repository.PeliculaRepository;
import org.kaven.kinal_play.persistence.crud.CrudPeliculaEntity;
import org.kaven.kinal_play.persistence.entity.PeliculaEntity;
import org.springframework.stereotype.Repository;
import org.kaven.kinal_play.web.mapper.PeliculaMapper;

import java.math.BigDecimal;
import java.util.List;


@Repository
public class PeliculaEntityRepository implements PeliculaRepository {

    //Inyeccion de dependencias implicito: sin el @Autowire
    private final CrudPeliculaEntity crudPelicula;
    private final PeliculaMapper peliculaMapper;

    public PeliculaEntityRepository(CrudPeliculaEntity crudPelicula, PeliculaMapper peliculaMapper) {
        this.crudPelicula = crudPelicula;
        this.peliculaMapper = peliculaMapper;
    }


    @Override
    public List<PeliculaDto> obtnerTodo() {
        return this.peliculaMapper.toDto(this.crudPelicula.findAll());
    }

    @Override
    public PeliculaDto obtenerPeliculaPorCodigo(Long codigo) {
        //PeliculaEntity peliculaEntity = this.crudPelicula.findById(codigo).orElse(null);
        //return this.peliculaMapper.toDto()
        return this.peliculaMapper.toDto(this.crudPelicula.findById(codigo).orElse(null));

    }

    @Override
    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto) {
        //Instanciar clase de Entidad
        PeliculaEntity pelicula = new PeliculaEntity();
        //Convertir Dto a Entity
        pelicula = this.peliculaMapper.toEntity(peliculaDto);
        //Guardar en la DB con JPA
        pelicula.setEstado("D");
        this.crudPelicula.save(pelicula);
        //Retornar el valor Guardado como Dto
        return this.peliculaMapper.toDto(pelicula);
    }

    @Override
    public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPeliculaDto) {
        //Obtenemos PeliculaEntity con el codigo
        PeliculaEntity pelicula = this.crudPelicula.findById(codigo).orElse(null);
        //Modificar atributos de ella con datos del mod
        pelicula.setNombre(modPeliculaDto.name());
        pelicula.setFechaEstreno(modPeliculaDto.releaseDate());
        pelicula.setCalificacion(BigDecimal.valueOf(modPeliculaDto.rating()));
        //Guardamos en la DB
        this.crudPelicula.save(pelicula);
        //Retornamos el PeliculaDto convertido de la entidad
        return this.peliculaMapper.toDto(pelicula);
    }
}