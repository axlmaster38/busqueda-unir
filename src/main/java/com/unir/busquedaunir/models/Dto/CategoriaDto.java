package com.unir.busquedaunir.models.Dto;

import lombok.*;

import javax.persistence.Table;

import com.unir.busquedaunir.entities.ProductoEntity;
import com.unir.busquedaunir.models.enums.Estado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaDto implements Serializable {

    private static final long SerialVersionUID = 1l;

    private int id;
    private String nombre;
    private String descripcion;
    private Estado estado;
    private List<ProductoDto> productos= new ArrayList<>();

}
