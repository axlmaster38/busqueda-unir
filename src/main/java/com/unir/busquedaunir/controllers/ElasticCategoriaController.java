package com.unir.busquedaunir.controllers;

import com.unir.busquedaunir.entities.ElasticCategoria;
import com.unir.busquedaunir.models.request.CreateCategoriaRequest;
import com.unir.busquedaunir.services.ElasticCategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ElasticCategoriaController {

    private final ElasticCategoriaService service;

    @GetMapping("/elastic/categorias/{categoriaId}")
    public ResponseEntity<ElasticCategoria> getCategoriaoById(@PathVariable String categoriaId) {
        ElasticCategoria categoria = service.getCategoriaById(categoriaId);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/elastic/categorias")
    public ResponseEntity<List<ElasticCategoria>> getCategoriaos() {
        List<ElasticCategoria> categorias = service.getAvailableCategorias();
        if (categorias != null) {
            return ResponseEntity.ok(categorias);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // nombre exacto
    @GetMapping("/elastic/categoria/match/{value}")
    public ResponseEntity<List<ElasticCategoria>> getCategoriaByName(@PathVariable String value) {
        List<ElasticCategoria> categoria = service.searchByNombreExacto(value);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // nombre
    @GetMapping("/elastic/categorias/search/as-you-type/{value}")
    public ResponseEntity<List<ElasticCategoria>> searchByName(@PathVariable String value) {
        List<ElasticCategoria> categoria = service.searchByName(value);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/elastic/categorias/search/full-text/{value}")
    public ResponseEntity<List<ElasticCategoria>> searchByDescription(@PathVariable String value) {

        List<ElasticCategoria> categoria = service.searchByDescription(value);

        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/elastic/categorias")
    public ResponseEntity<ElasticCategoria> getCategoria(@RequestBody CreateCategoriaRequest request) {

        ElasticCategoria createdCategoria = service.createCategoria(request);

        if (createdCategoria != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoria);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }


}
