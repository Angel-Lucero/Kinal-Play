package org.kaven.kinal_play.dominio.exception;

public class TiempoDuracionException extends RuntimeException {
    public TiempoDuracionException(String duracion) {
        super("La duración de la pelicula tiene que ser mayor que 0\n"
              + "Duración a cambiar: "  + duracion);
    }
}
