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

    @GetMapping("/elastic/producto/{productoId}")
    public ResponseEntity<ElasticProducto> getProductoById(@PathVariable String productoId) {
        ElasticProducto producto = service.getProductById(productoId);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/elastic/producto")
    public ResponseEntity<List<ElasticProducto>> getProductos() {
        List<ElasticProducto> productos = service.getAvailableProducts();
        if (productos != null) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@GetMapping("/elastic/producto/match/{value}")
    public ResponseEntity<ElasticProducto> getProductByName(@PathVariable String value) {
        ElasticProducto producto = service.getProductByName(value);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/



    @GetMapping("/elastic/producto/search/full-text/{value}")
    public ResponseEntity<List<ElasticProducto>> searchByName(@PathVariable String value) {
        List<ElasticProducto> producto = service.searchByName(value);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/elastic/products")
    public ResponseEntity<ElasticProducto> getProduct(@RequestBody CreateProductRequest request) {

        ElasticProducto createdProduct = service.createProduct(request);

        if (createdProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }


}
