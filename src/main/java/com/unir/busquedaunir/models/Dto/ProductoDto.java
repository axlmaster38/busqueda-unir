package com.unir.busquedaunir.models.Dto;

import lombok.*;

import javax.persistence.Table;

import com.unir.busquedaunir.models.enums.Estado;
import com.unir.busquedaunir.models.enums.TipoUnidad;

import java.io.Serializable;

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
