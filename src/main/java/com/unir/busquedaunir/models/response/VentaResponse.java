package com.unir.busquedaunir.models.response;

import java.util.Date;
import java.util.List;

import com.unir.busquedaunir.entities.ClienteEntity;
import com.unir.busquedaunir.entities.ProductoVentaEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaResponse {

    private int id;
    private Date fecha;
    private int numeroFactura;
    private int total;
    private ClienteEntity cliente;
    private List<ProductoVentaEntity> productos;


}