package com.unir.busquedaunir.models.Dto;

import com.unir.busquedaunir.models.enums.TipoDocumento;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto {

    private int id;
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private String documento;
    private String telefono;
    private String email;
    private String direccion;
    private Date fechaCreación ;
    private String usuarioCreacion;
    private Date fechaModificacion ;
    private String usuarioModificacion;
}
