package org.kaven.kinal_play.dominio.exception;

public class GeneroNoExisteException extends RuntimeException{
    public GeneroNoExisteException(String generoPelicula){
        super("No existe el genero : " + generoPelicula + "Utiliza uno de los siguientes: ACCION," +
                " ANIMADA," +
                " CIENCIA_FICCION," +
                " CRIMEN," +
                " DRAMA," +
                " DRAMA_BELICO," +
                " FANTASIA," +
                " SUSPENSO," +
                " HORROR ");
    }
}
