package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticProveedor;
import com.unir.busquedaunir.models.request.CreateProveedorRequest;

import java.util.List;

public interface ElasticProveedorService {

    ElasticProveedor createProveedor(CreateProveedorRequest request);
    ElasticProveedor getProveedorById(String proveedoroId);
    List<ElasticProveedor> searchByNombreExacto(String nombre);
    List<ElasticProveedor> searchByName(String nombre);
   // List<ElasticProveedor>  searchByApellido (String apellido);
    //List<ElasticProveedor> searchByApellidoExacto(String codigo);
    List<ElasticProveedor> getAvailableProveedors();
}
