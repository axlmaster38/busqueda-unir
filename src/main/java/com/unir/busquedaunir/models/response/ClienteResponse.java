package com.unir.busquedaunir.models.response;

import com.unir.busquedaunir.models.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private int id;
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private String documento;
    private String telefono;
    private String email;
    private String direccion;

}
