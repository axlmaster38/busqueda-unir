package com.unir.busquedaunir.controllers;

import com.unir.busquedaunir.entities.ElasticCliente;
import com.unir.busquedaunir.models.request.CreateClienteRequest;
import com.unir.busquedaunir.services.ElasticClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ElasticClienteController {

    private final ElasticClienteService service;

    @GetMapping("/elastic/clientes/{clienteId}")
    public ResponseEntity<ElasticCliente> getClienteoById(@PathVariable String clienteId) {
        ElasticCliente cliente = service.getClienteById(clienteId);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/elastic/clientes")
    public ResponseEntity<List<ElasticCliente>> getClientes() {
        List<ElasticCliente> clientes = service.getAvailableClientes();
        if (clientes != null) {
            return ResponseEntity.ok(clientes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // nombre exacto
    @GetMapping("/elastic/cliente/match/{value}")
    public ResponseEntity<List<ElasticCliente>> getClienteByName(@PathVariable String value) {
        List<ElasticCliente> cliente = service.searchByNombreExacto(value);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // nombre
    @GetMapping("/elastic/clientes/search/as-you-type/{value}")
    public ResponseEntity<List<ElasticCliente>> searchByName(@PathVariable String value) {
        List<ElasticCliente> cliente = service.searchByName(value);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/elastic/clientes")
    public ResponseEntity<ElasticCliente> getCliente(@RequestBody CreateClienteRequest request) {

        ElasticCliente createdCliente = service.createCliente(request);

        if (createdCliente != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }


}
