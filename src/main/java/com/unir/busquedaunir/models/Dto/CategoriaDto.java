package com.unir.busquedaunir.models.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.unir.busquedaunir.models.enums.Estado;

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
public class CategoriaDto implements Serializable {

    private static final long SerialVersionUID = 1l;

    private int id;
    private String nombre;
    private String descripcion;
    private Estado estado;
    private List<ProductoDto> productos= new ArrayList<>();

}
