package com.unir.busquedaunir.models.Dto;

import com.unir.busquedaunir.models.enums.TipoDocumento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProveedorDto {

    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private String documento;
    private String telefono;
    private String email;
    private String direccion;
    private String empresa;

}
