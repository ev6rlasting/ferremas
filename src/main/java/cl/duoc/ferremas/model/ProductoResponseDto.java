package cl.duoc.ferremas.model;


import java.util.List;

public record ProductoResponseDto(
        String nombre,

        String categoria,

        String marca,

        Float precio,

        Long stock,

        List<Long> idsSucursal
) {}
