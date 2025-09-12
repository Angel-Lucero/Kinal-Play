package org.kaven.kinal_play.dominio.exception;

import java.math.BigDecimal;

public class RangoCalificacionInvalidoException extends RuntimeException {
  public RangoCalificacionInvalidoException(BigDecimal rango) {
      super("El rango de la calicación no puede ser mayor que 9.9 ni menor que 0, Calificación a cambiar:" + rango);
  }
}
