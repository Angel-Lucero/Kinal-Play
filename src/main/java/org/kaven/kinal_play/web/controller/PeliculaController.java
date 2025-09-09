package org.kaven.kinal_play.web.controller;

import org.kaven.kinal_play.dominio.dto.ModPeliculaDto;
import org.kaven.kinal_play.dominio.dto.PeliculaDto;
import org.kaven.kinal_play.dominio.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas/v1")//Controla todas las
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
        return;ResponseEntity.ok(this.peliculaService.obtenerTodo());
    }
    // 4
    @GetMapping("{codigo}")
    public ResponseEntity<PeliculaDto> obtenerPeliculaPorCodigo(@PathVariable Long codigo){
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
    @PutMapping
    public ResponseEntity<PeliculaDto> modificarPelicula
    (@PathVariable Long codigo, @RequestBody ModPeliculaDto peliculaDto){
        return ResponseEntity.ok().build();
    }
    //eliminarPelicula

    //exception - PeliculaNoExisteException, PeliculaYaExisteException

    //Consulta a la isa
    //Validaciones (dependencias)
    //Documentación (dependencias)

}

