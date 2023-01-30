package com.unir.busquedaunir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.busquedaunir.entities.CompraEntity;
import com.unir.busquedaunir.models.Dto.CompraDto;
import com.unir.busquedaunir.services.CompraServiceImpl;


@RestController
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    private CompraServiceImpl compraService;
    @PostMapping
    public ResponseEntity<?> getCompra(@RequestBody CompraDto compraDto){
        String body = "Ingresa algun valor de busqueda";
        List<CompraEntity> compraEntities = compraService.getCompra(compraDto);
        if(compraEntities != null)
            return new ResponseEntity<>(compraEntities,null, HttpStatus.OK );
        else
            return new ResponseEntity<>(body, null, HttpStatus.NO_CONTENT);
    }

}
