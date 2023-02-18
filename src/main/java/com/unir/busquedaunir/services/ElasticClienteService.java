package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticCliente;
import com.unir.busquedaunir.models.request.CreateClienteRequest;

import java.util.List;

public interface ElasticClienteService {

    ElasticCliente createCliente(CreateClienteRequest request);
    ElasticCliente getClienteById(String clienteoId);
    List<ElasticCliente> searchByNombreExacto(String codigo);
    List<ElasticCliente> searchByName(String clienteName);
    List<ElasticCliente>  searchByApellido (String apellido);
    List<ElasticCliente> searchByApellidoExacto(String codigo);
    List<ElasticCliente> getAvailableClientes();
}
