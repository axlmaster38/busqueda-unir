package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticVenta;
import com.unir.busquedaunir.models.request.CreateVentaRequest;

import java.util.List;

public interface ElasticVentaService {

    ElasticVenta createVenta(CreateVentaRequest request);
    ElasticVenta getVentaById(String ventaoId);
    List<ElasticVenta> searchByFechaExacto(String codigo);
    List<ElasticVenta>  searchByFactura (String apellido);
    List<ElasticVenta> searchByFacturaExacto(String codigo);
    List<ElasticVenta> getAvailableVentas();
}
