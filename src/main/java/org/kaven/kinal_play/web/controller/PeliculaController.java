package org.kaven.kinal_play.web.controller;

import org.kaven.kinal_play.dominio.dto.PeliculaDto;
import org.kaven.kinal_play.dominio.service.PeliculaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping//Controla todas las
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/peliculas")
    public List<PeliculaDto> obtenerTodo(){
        return this.peliculaService.obtenerTodo();
    }

    @GetMapping("/peliculas/{codigo}")
    public PeliculaDto obtenerPeliculaPorCodigo(@PathVariable Long codigo){
        return this.peliculaService.obtenerPeliculaPorCodigo(codigo);
    }
}

