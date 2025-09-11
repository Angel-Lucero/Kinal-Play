package org.kaven.kinal_play.dominio.exception;

public class RangoCalificacionException extends RuntimeException {
  public RangoCalificacionException(String rango) {
      super("El rango de la calicación no puede ser mayor que 9.9 ni menor que 0\n"
      + "Calificación a cambiar:" + rango);
  }
}
