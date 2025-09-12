package org.kaven.kinal_play.dominio.exception;

public class TiempoDuracionInvalidoException extends RuntimeException {
    public TiempoDuracionInvalidoException(Integer duracion) {
        super("La duración de la pelicula tiene que ser mayor que 0, Duración a cambiar: "  + duracion);
    }
}
