package com.unir.busquedaunir.controllers;

import com.unir.busquedaunir.entities.ElasticProducto;
import com.unir.busquedaunir.models.request.CreateProductRequest;
import com.unir.busquedaunir.services.ElasticProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ElasticProductoController {

    private final ElasticProductoService service;

    @GetMapping("/elastic/productos/{productoId}")
    public ResponseEntity<ElasticProducto> getProductoById(@PathVariable String productoId) {
        ElasticProducto producto = service.getProductById(productoId);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/elastic/productos")
    public ResponseEntity<List<ElasticProducto>> getProductos() {
        List<ElasticProducto> productos = service.getAvailableProducts();
        if (productos != null) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // codigo exacto
    @GetMapping("/elastic/producto/match/{value}")
    public ResponseEntity<List<ElasticProducto>> getProductByCodigo(@PathVariable String value) {
        List<ElasticProducto> producto = service.searchByCodigoExacto(value);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // nombre
    @GetMapping("/elastic/productos/search/as-you-type/{value}")
    public ResponseEntity<List<ElasticProducto>> searchByName(@PathVariable String value) {
        List<ElasticProducto> producto = service.searchByName(value);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // codigo
    @GetMapping("/elastic/productos/searchcode/{value}")
    public ResponseEntity<List<ElasticProducto>> searchByCodigo(@PathVariable String value) {
        List<ElasticProducto> producto = service.searchByCodigo(value);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/elastic/productos")
    public ResponseEntity<ElasticProducto> getProduct(@RequestBody CreateProductRequest request) {

        ElasticProducto createdProduct = service.createProduct(request);

        if (createdProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }


}
