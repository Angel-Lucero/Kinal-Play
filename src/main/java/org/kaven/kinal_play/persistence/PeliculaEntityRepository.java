package org.kaven.kinal_play.persistence;

import org.kaven.kinal_play.dominio.dto.ModPeliculaDto;
import org.kaven.kinal_play.dominio.dto.PeliculaDto;
import org.kaven.kinal_play.dominio.exception.PeliculaNoExisteException;
import org.kaven.kinal_play.dominio.exception.PeliculaYaExisteException;
import org.kaven.kinal_play.dominio.repository.PeliculaRepository;
import org.kaven.kinal_play.persistence.crud.CrudPeliculaEntity;
import org.kaven.kinal_play.persistence.entity.PeliculaEntity;
import org.springframework.stereotype.Repository;
import org.kaven.kinal_play.web.mapper.PeliculaMapper;

import java.math.BigDecimal;
import java.util.IllegalFormatCodePointException;
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
        PeliculaEntity peliculaEntity = this.crudPelicula.findById(codigo).orElse(null);
        if (peliculaEntity == null) throw new PeliculaNoExisteException(codigo);
        else {
            return this.peliculaMapper.toDto(this.crudPelicula.findById(codigo).orElse(null));
        }
    }

    @Override
    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto) {
        //buscar por titulo
        // ya no se necesita por el if: PeliculaEntity peliculaEntity = this.crudPelicula.findFirstByNombre(peliculaDto.name());
        //Instanciar clase de Entidad
        if (this.crudPelicula.findFirstByNombre(peliculaDto.name()) != null){
            throw new PeliculaYaExisteException(peliculaDto.name());
        }
        //Convertir Dto a Entity
        PeliculaEntity pelicula = this.peliculaMapper.toEntity(peliculaDto);
        pelicula.setEstado("D");
        //Guardar en la DB con JPA
        this.crudPelicula.save(pelicula);
        //Retornar el valor Guardado como Dto
        return this.peliculaMapper.toDto(pelicula);
    }

        @Override
        public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPeliculaDto) {
            //Obtenemos PeliculaEntity con el codigo
            PeliculaEntity peliculaEntity = this.crudPelicula.findById(codigo).orElse(null);
            //Modificar atributos de ella con datos del mod
            //pelicula.setNombre(modPeliculaDto.name());
            //pelicula.setFechaEstreno(modPeliculaDto.releaseDate());
            //pelicula.setCalificacion(BigDecimal.valueOf(modPeliculaDto.rating()));
            //Guardamos en la DB
            //this.crudPelicula.save(pelicula);
            //Retornamos el PeliculaDto convertido de la entidad
            if (peliculaEntity == null) throw new PeliculaNoExisteException(codigo);
            else {
                this.peliculaMapper.modificarEntityFromDto(modPeliculaDto, peliculaEntity);
                return this.peliculaMapper.toDto(this.crudPelicula.save(peliculaEntity));
            }
        }

        @Override
        public void eliminarPelicula(Long codigo){
            PeliculaEntity peliculaEntity = this.crudPelicula.findById(codigo).orElse(null);
            if (peliculaEntity == null){
                //Exepción
                throw new PeliculaNoExisteException(codigo);
            }else {
                this.crudPelicula.findById(codigo);
            }
            // de PeliculaDto a void
            //peliculaEntity = this.crudPelicula.findById(codigo).orElse(null);
            //if (peliculaEntity == null) return null;
            //this.crudPelicula.delete(peliculaEntity);
            //return this.peliculaMapper.toDto(peliculaEntity);
        }
}