package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticProveedor;
import com.unir.busquedaunir.models.request.CreateProveedorRequest;
import com.unir.busquedaunir.repositories.ElasticsearchCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ElasticProveedorServiceImpl implements  ElasticProveedorService{

    private final ElasticsearchProveedorRepository repo;

    @Override
    public ElasticProveedor createProveedor(CreateProveedorRequest request) {
        return null;
    }

    @Override
    public ElasticProveedor getProveedorById(String proveedoroId) {
        return null;
    }

    @Override
    public List<ElasticProveedor> searchByNombreExacto(String codigo) {
        return null;
    }

    @Override
    public List<ElasticProveedor> searchByName(String proveedorName) {
        return null;
    }

    @Override
    public List<ElasticProveedor> searchByApellido(String apellido) {
        return null;
    }

    @Override
    public List<ElasticProveedor> searchByApellidoExacto(String codigo) {
        return null;
    }

    @Override
    public List<ElasticProveedor> getAvailableProveedors() {
        return null;
    }
}
