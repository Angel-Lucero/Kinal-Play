package org.kaven.kinal_play.persistence;

import org.kaven.kinal_play.dominio.dto.PeliculaDto;
import org.kaven.kinal_play.dominio.repository.PeliculaRepository;
import org.kaven.kinal_play.persistence.crud.CrudPeliculaEntity;
import org.kaven.kinal_play.persistence.entity.PeliculaEntity;
import org.springframework.stereotype.Repository;
import org.kaven.kinal_play.web.mapper.PeliculaMapper;

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
        return this.peliculaMapper.toDto(this.crudPelicula.findById(codigo).orElse(null));
    }
}