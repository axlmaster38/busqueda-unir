package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticCliente;
import com.unir.busquedaunir.entities.ElasticProducto;
import com.unir.busquedaunir.models.request.CreateClienteRequest;
import com.unir.busquedaunir.repositories.ElasticsearchCategoriaRepository;
import com.unir.busquedaunir.repositories.ElasticsearchClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ElasticClienteServiceImpl implements  ElasticClienteService{

    private final ElasticsearchClienteRepository repo;

    @Override
    public ElasticCliente createCliente(CreateClienteRequest request) {


        if (request != null && StringUtils.hasLength(request.getNombre())
                && StringUtils.hasLength(request.getApellido())
        ) {

            ElasticCliente cliente =
                    ElasticCliente.builder().id(request.getId())
                            .nombre(request.getNombre())
                            .apellido(request.getApellido())
                            .tipoDocumento(request.getTipoDocumento())
                            .documento(request.getDocumento())
                            .direccion(request.getDireccion())
                            .telefono(request.getTelefono())
                            .email(request.getEmail())
                            .build();

            return repo.saveCliente(cliente);
        } else {
            return null;
        }
    }

    @Override
    public ElasticCliente getClienteById(String clienteId) {
        return  repo.getById(clienteId);
    }

    @Override
    public List<ElasticCliente> searchByNombreExacto(String nombre) {
        return repo.searchByNombreExacto(nombre);
    }

    @Override
    public List<ElasticCliente> searchByName(String clienteName) {
        return repo.searchByName(clienteName);
    }

    /*
    @Override
    public List<ElasticCliente> searchByApellido(String apellido) {
        return null;
    }

    @Override
    public List<ElasticCliente> searchByApellidoExacto(String codigo) {
        return null;
    }*/

    @Override
    public List<ElasticCliente> getAvailableClientes() {
        Iterable<ElasticCliente> clientes= repo.getAll();
        List<ElasticCliente> p = new ArrayList<>();
        for(ElasticCliente cliente: clientes){
            p.add(cliente);
        }
        return p;
    }
}
