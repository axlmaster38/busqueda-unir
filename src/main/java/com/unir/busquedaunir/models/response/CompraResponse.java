package com.unir.busquedaunir.models.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraResponse {

    private int id;
    private Date fecha;
    private String proveedor_id;
    private String numero_factura;
    private String productos;
    private int total;

}
