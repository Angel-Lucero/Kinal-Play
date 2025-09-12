package org.kaven.kinal_play.web.mapper;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper {
    @Named("generarStatus")
    public Boolean stringABoolean(String estado) {
        if (estado == null) return null;
        return switch (estado.toUpperCase()) {
            case "D" -> true;
            case "N" -> false;
            default -> null;
        };
    }

    @Named("generarEstado")
    public String booleanAString(Boolean status) {
        if (status == null) return null;
        return status ? "D" : "N";
    }
}
