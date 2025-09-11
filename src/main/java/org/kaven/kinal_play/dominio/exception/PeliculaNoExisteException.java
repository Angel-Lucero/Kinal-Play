package org.kaven.kinal_play.dominio.exception;

public class PeliculaNoExisteException extends RuntimeException{
    public PeliculaNoExisteException(Long codigoPelicula){
        super("La pelicula con código: " + codigoPelicula + " no existe en el sistema.");
    }
}
