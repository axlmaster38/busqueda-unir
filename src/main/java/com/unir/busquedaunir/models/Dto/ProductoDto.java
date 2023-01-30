package com.unir.busquedaunir.models.Dto;

import java.io.Serializable;

import com.unir.busquedaunir.models.enums.Estado;
import com.unir.busquedaunir.models.enums.TipoUnidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDto implements Serializable {

    private static final long SerialVersionUID = 1l;

    private int id;
    private String nombre;
    private String codigo;
    private int cantidad;
    private int precio;
    private Estado estado;
    private TipoUnidad unidad;
    private int categoria_id;

}
