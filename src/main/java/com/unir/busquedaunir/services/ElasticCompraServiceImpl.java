package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticCompra;
import com.unir.busquedaunir.models.request.CreateCompraRequest;
import com.unir.busquedaunir.repositories.ElasticsearchCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ElasticCompraServiceImpl implements  ElasticCompraService{

    private final ElasticsearchCompraRepository repo;

    @Override
    public ElasticCompra createCompra(CreateCompraRequest request) {
        return null;
    }

    @Override
    public ElasticCompra getCompraById(String compraoId) {
        return null;
    }

    @Override
    public List<ElasticCompra> searchByFechaExacto(String codigo) {
        return null;
    }

    @Override
    public List<ElasticCompra> searchByFactura(String apellido) {
        return null;
    }

    @Override
    public List<ElasticCompra> searchByFacturaExacto(String codigo) {
        return null;
    }

    @Override
    public List<ElasticCompra> getAvailableCompras() {
        return null;
    }
}
