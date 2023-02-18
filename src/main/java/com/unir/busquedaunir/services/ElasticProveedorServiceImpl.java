package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticCliente;
import com.unir.busquedaunir.entities.ElasticProducto;
import com.unir.busquedaunir.entities.ElasticProveedor;
import com.unir.busquedaunir.models.request.CreateProveedorRequest;
import com.unir.busquedaunir.repositories.ElasticsearchCategoriaRepository;
import com.unir.busquedaunir.repositories.ElasticsearchProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ElasticProveedorServiceImpl implements  ElasticProveedorService{

    private final ElasticsearchProveedorRepository repo;

    @Override
    public ElasticProveedor createProveedor(CreateProveedorRequest request) {

        if (request != null && StringUtils.hasLength(request.getNombre())
                && StringUtils.hasLength(request.getApellido())
        ) {

            ElasticProveedor proveedor =
                    ElasticProveedor.builder().id(String.valueOf(request.getNombre().hashCode()))
                            .nombre(request.getNombre())
                            .apellido(request.getApellido())
                            .tipoDocumento(request.getTipoDocumento())
                            .documento(request.getDocumento())
                            .direccion(request.getDireccion())
                            .telefono(request.getTelefono())
                            .email(request.getEmail())
                            .empresa(request.getEmpresa())
                            .build();

            return repo.saveProveedor(proveedor);
        } else {
            return null;
        }
    }

    @Override
    public ElasticProveedor getProveedorById(String proveedorId) {
        return repo.getById(proveedorId);
    }

    @Override
    public List<ElasticProveedor> searchByNombreExacto(String nombre) {
        return repo.searchByNombreExacto(nombre);
    }

    @Override
    public List<ElasticProveedor> searchByName(String nombre) {
        return repo.searchByName(nombre);
    }
/*
    @Override
    public List<ElasticProveedor> searchByApellido(String apellido) {
        return null;
    }

    @Override
    public List<ElasticProveedor> searchByApellidoExacto(String codigo) {
        return null;
        }
    */

    @Override
    public List<ElasticProveedor> getAvailableProveedors() {
        Iterable<ElasticProveedor> proveedores= repo.getAll();
        List<ElasticProveedor> p = new ArrayList<>();
        for(ElasticProveedor proveedor: proveedores){
            p.add(proveedor);
        }
        return p;
    }
}
