package org.kaven.kinal_play.web.exception;

import org.kaven.kinal_play.dominio.exception.*;
import org.kaven.kinal_play.dominio.exception.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(PeliculaYaExisteException.class)
    public ResponseEntity <Error> handleException(PeliculaYaExisteException ex) {
        Error error = new Error("pelicula-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(PeliculaNoExisteException.class)
    public ResponseEntity <Error> handleException(PeliculaNoExisteException ex) {
        Error error = new Error("pelicula-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(GeneroNoExisteException.class)
    public ResponseEntity <Error> handleException(GeneroNoExisteException ex){
        Error error = new Error("genero-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(RangoCalificacionInvalidoException.class)
    public ResponseEntity <Error> handleException(RangoCalificacionInvalidoException ex){
        Error error = new Error("rango-calificacion-invalido", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(TiempoDuracionInvalidoException.class)
    public ResponseEntity <Error> handleException(TiempoDuracionInvalidoException ex){
        Error error = new Error("tiempo-duracion-invalido", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errores.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity <Error> handleException(Exception ex){
        Error error = new Error("error-desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }




}
