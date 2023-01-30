package com.unir.busquedaunir.models.Dto;

import java.util.Date;
import java.util.List;

import com.unir.busquedaunir.entities.ProductoVentaEntity;

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
public class VentaDto {

    private int id;
    private Date fecha;
    private int numero_factura;
    private int total;
    private int cliente_id;
    private int user_id;
    private List<ProductoVentaEntity> productos;


    private Date fechaCreación ;
    private String usuarioCreacion;
    private Date fechaModificacion ;
    private String usuarioModificacion;
}
