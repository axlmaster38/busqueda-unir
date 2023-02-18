package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticCliente;
import com.unir.busquedaunir.models.request.CreateClienteRequest;
import com.unir.busquedaunir.repositories.ElasticsearchCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ElasticClienteServiceImpl implements  ElasticClienteService{

    private final ElasticsearchClienteRepository repo;

    @Override
    public ElasticCliente createCliente(CreateClienteRequest request) {
        return null;
    }

    @Override
    public ElasticCliente getClienteById(String clienteoId) {
        return null;
    }

    @Override
    public List<ElasticCliente> searchByNombreExacto(String codigo) {
        return null;
    }

    @Override
    public List<ElasticCliente> searchByName(String clienteName) {
        return null;
    }

    @Override
    public List<ElasticCliente> searchByApellido(String apellido) {
        return null;
    }

    @Override
    public List<ElasticCliente> searchByApellidoExacto(String codigo) {
        return null;
    }

    @Override
    public List<ElasticCliente> getAvailableClientes() {
        return null;
    }
}
