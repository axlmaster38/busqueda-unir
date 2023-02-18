package com.unir.busquedaunir.controllers;

import com.unir.busquedaunir.entities.ElasticCompra;
import com.unir.busquedaunir.models.request.CreateCompraRequest;
import com.unir.busquedaunir.services.ElasticCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ElasticCompraController {

    private final ElasticCompraService service;

    @GetMapping("/elastic/compras/{compraId}")
    public ResponseEntity<ElasticCompra> getCompraoById(@PathVariable String compraId) {
        ElasticCompra compra = service.getCompraById(compraId);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/elastic/compras")
    public ResponseEntity<List<ElasticCompra>> getCompraos() {
        List<ElasticCompra> compras = service.getAvailableCompras();
        if (compras != null) {
            return ResponseEntity.ok(compras);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // fecha exacto
    @GetMapping("/elastic/compra/matchdate/{value}")
    public ResponseEntity<List<ElasticCompra>> getCompraByFecha(@PathVariable String value) {
        List<ElasticCompra> compra = service.searchByFechaExacto(value);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // numero factura exacto
    @GetMapping("/elastic/compra/match/{value}")
    public ResponseEntity<List<ElasticCompra>> getCompraByFactura(@PathVariable String value) {
        List<ElasticCompra> compra = service.searchByFacturaExacto(value);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // factura
    @GetMapping("/elastic/compras/search/as-you-type/{value}")
    public ResponseEntity<List<ElasticCompra>> searchByFactura(@PathVariable String value) {
        List<ElasticCompra> compra = service.searchByFactura(value);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/elastic/compras")
    public ResponseEntity<ElasticCompra> getCompra(@RequestBody CreateCompraRequest request) {

        ElasticCompra createdCompra = service.createCompra(request);

        if (createdCompra != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCompra);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }


}
