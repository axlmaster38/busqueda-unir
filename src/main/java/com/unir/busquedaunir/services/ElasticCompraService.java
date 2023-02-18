package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticCompra;
import com.unir.busquedaunir.models.request.CreateCompraRequest;

import java.util.List;

public interface ElasticCompraService {

    ElasticCompra createCompra(CreateCompraRequest request);
    ElasticCompra getCompraById(String compraoId);
    List<ElasticCompra> searchByFechaExacto(String codigo);
    List<ElasticCompra>  searchByFactura (String apellido);
    List<ElasticCompra> searchByFacturaExacto(String codigo);
    List<ElasticCompra> getAvailableCompras();
}
