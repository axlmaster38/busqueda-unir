package com.unir.busquedaunir.controllers;

import com.unir.busquedaunir.entities.ElasticVenta;
import com.unir.busquedaunir.models.request.CreateVentaRequest;
import com.unir.busquedaunir.services.ElasticVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin

public class ElasticVentaController {

    private final ElasticVentaService service;

    @GetMapping("/elastic/ventas/{ventaId}")
    public ResponseEntity<ElasticVenta> getVentaoById(@PathVariable String ventaId) {
        ElasticVenta venta = service.getVentaById(ventaId);
        if (venta != null) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/elastic/ventas")
    public ResponseEntity<List<ElasticVenta>> getVentaos() {
        List<ElasticVenta> ventas = service.getAvailableVentas();
        if (ventas != null) {
            return ResponseEntity.ok(ventas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // fecha exacto
    @GetMapping("/elastic/venta/matchdate/{value}")
    public ResponseEntity<List<ElasticVenta>> getVentaByFecha(@PathVariable String value) {
        List<ElasticVenta> venta = service.searchByFechaExacto(value);
        if (venta != null) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // numero factura exacto
    @GetMapping("/elastic/venta/match/{value}")
    public ResponseEntity<List<ElasticVenta>> getVentaByFactura(@PathVariable String value) {
        List<ElasticVenta> venta = service.searchByFacturaExacto(value);
        if (venta != null) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // factura
    @GetMapping("/elastic/ventas/search/as-you-type/{value}")
    public ResponseEntity<List<ElasticVenta>> searchByFactura(@PathVariable String value) {
        List<ElasticVenta> venta = service.searchByFactura(value);
        if (venta != null) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/elastic/ventas")
    public ResponseEntity<ElasticVenta> getVenta(@RequestBody CreateVentaRequest request) {

        ElasticVenta createdVenta = service.createVenta(request);

        if (createdVenta != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdVenta);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }


}
