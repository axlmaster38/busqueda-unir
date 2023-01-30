package com.unir.busquedaunir.models.Dto;



import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompraDto {

    private int id;
    private Date fecha_creacion;
    private Date fecha;
    private int proveedor_id;
    private int total;
    private int numero_factura;

}