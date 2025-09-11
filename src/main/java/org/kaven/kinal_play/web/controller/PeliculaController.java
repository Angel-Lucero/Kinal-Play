package org.kaven.kinal_play.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kaven.kinal_play.dominio.dto.ModPeliculaDto;
import org.kaven.kinal_play.dominio.dto.PeliculaDto;
import org.kaven.kinal_play.dominio.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/peliculas")
@Tag(name = "Peliculas", description = "Operaciones(CRUD) para todas las peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerTodo(){
        //200: OK
        //404: No lo encuentra,no existe, mal nombre
        //500: Interno del servido, erro de lógica
        //405: Metodo de solicitud incorrecto
        //return this.peliculaService.obtenerTodo();
        return ResponseEntity.ok(this.peliculaService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary =  "Obtener una pelicula a partit de su codigo",
            description = "Retorna la pelicula que coincida con el codigo enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "La pelicula fue encontrada con exito"),
                    @ApiResponse(responseCode = "404", description = "Pelicula no encontrada", content = @Content)
            }
    )
    public ResponseEntity<PeliculaDto> obtenerPeliculaPorCodigo
            (@Parameter(description = "Identificador de la pelicula a recuperar", example = "5")
             @PathVariable Long codigo){
        //return this.peliculaService.obtenerPeliculaPorCodigo(codigo);
        return ResponseEntity.ok(this.peliculaService.obtenerPeliculaPorCodigo(codigo));
    }

    //guardarPelicula
    @PostMapping
    public ResponseEntity<PeliculaDto> guardarPelicula
    (@RequestBody PeliculaDto peliculaDto){
        //return this.peliculaService.guardarPelicula(peliculaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.peliculaService
                .guardarPelicula(peliculaDto));
    }
    //modificarPelicula
    @PutMapping("{codigo}")
    public ResponseEntity<PeliculaDto> modificarPelicula
    (@PathVariable Long codigo, @RequestBody @Valid ModPeliculaDto modpeliculaDto){
        return ResponseEntity.ok(this.peliculaService.modificarPelicula(codigo, modpeliculaDto));
    }

    //eliminarPelicula
    @DeleteMapping("{codigo}")
    public ResponseEntity<PeliculaDto> eliminarPelicula(@PathVariable Long codigo){
        this.peliculaService.obtenerPeliculaPorCodigo(codigo);
        return ResponseEntity.ok().build();
    }

    //exception - PeliculaNoExisteException, PeliculaYaExisteException

    //Consulta a la isa
    //Validaciones (dependencias)
    //Documentación (dependencias)

}

