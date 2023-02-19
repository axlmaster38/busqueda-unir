package com.unir.busquedaunir.controllers;

import com.unir.busquedaunir.entities.ElasticProveedor;
import com.unir.busquedaunir.models.request.CreateProveedorRequest;
import com.unir.busquedaunir.services.ElasticProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ElasticProveedorController {

    private final ElasticProveedorService service;

    @GetMapping("/elastic/proveedores/{proveedorId}")
    public ResponseEntity<ElasticProveedor> getProveedoroById(@PathVariable String proveedorId) {
        ElasticProveedor proveedor = service.getProveedorById(proveedorId);
        if (proveedor != null) {
            return ResponseEntity.ok(proveedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/elastic/proveedores")
    public ResponseEntity<List<ElasticProveedor>> getProveedoros() {
        List<ElasticProveedor> proveedores = service.getAvailableProveedors();
        if (proveedores != null) {
            return ResponseEntity.ok(proveedores);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // nombre exacto
    @GetMapping("/elastic/proveedor/match/{value}")
    public ResponseEntity<List<ElasticProveedor>> getProveedorByName(@PathVariable String value) {
        List<ElasticProveedor> proveedor = service.searchByNombreExacto(value);
        if (proveedor != null) {
            return ResponseEntity.ok(proveedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // nombre
    @GetMapping("/elastic/proveedores/search/as-you-type/{value}")
    public ResponseEntity<List<ElasticProveedor>> searchByName(@PathVariable String value) {
        List<ElasticProveedor> proveedor = service.searchByName(value);
        if (proveedor != null) {
            return ResponseEntity.ok(proveedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


/*
    // apellido exacto
    @GetMapping("/elastic/proveedor/match/{value}")
    public ResponseEntity<List<ElasticProveedor>> getProveedorByApellido(@PathVariable String value) {
        List<ElasticProveedor> proveedor = service.searchByApellidoExacto(value);
        if (proveedor != null) {
            return ResponseEntity.ok(proveedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // apellido
    @GetMapping("/elastic/proveedores/search/as-you-type/{value}")
    public ResponseEntity<List<ElasticProveedor>> searchByApellido(@PathVariable String value) {
        List<ElasticProveedor> proveedor = service.searchByApellido(value);
        if (proveedor != null) {
            return ResponseEntity.ok(proveedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
*/

    @PostMapping("/elastic/proveedores")
    public ResponseEntity<ElasticProveedor> getProveedor(@RequestBody CreateProveedorRequest request) {

        ElasticProveedor createdProveedor = service.createProveedor(request);

        if (createdProveedor != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProveedor);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }


}
