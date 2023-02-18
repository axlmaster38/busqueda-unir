package com.unir.busquedaunir.services;


import com.unir.busquedaunir.entities.ElasticVenta;
import com.unir.busquedaunir.models.request.CreateVentaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ElasticVentaServiceImpl implements ElasticVentaService {
    private final ElasticsearchVentaRepository repo;
    @Override
    public ElasticVenta createVenta(CreateVentaRequest request) {
        return null;
    }

    @Override
    public ElasticVenta getVentaById(String ventaoId) {
        return null;
    }

    @Override
    public List<ElasticVenta> searchByFechaExacto(String codigo) {
        return null;
    }

    @Override
    public List<ElasticVenta> searchByFactura(String apellido) {
        return null;
    }

    @Override
    public List<ElasticVenta> searchByFacturaExacto(String codigo) {
        return null;
    }

    @Override
    public List<ElasticVenta> getAvailableVentas() {
        return null;
    }
}
