package com.unir.busquedaunir.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.busquedaunir.entities.VentaEntity;
import com.unir.busquedaunir.models.Dto.VentaDto;
import com.unir.busquedaunir.services.VentaServiceImpl;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaServiceImpl ventaService;

    @PostMapping
    public ResponseEntity<?> getventa(@RequestBody VentaDto ventaDto){
        String body = "Ingresa algun valor de busqueda";
        List<VentaEntity> ventaEntities = ventaService.getVenta(ventaDto);
        if(ventaEntities != null)
            return new ResponseEntity<>(ventaEntities,null, HttpStatus.OK );
        else
            return new ResponseEntity<>(body, null, HttpStatus.NO_CONTENT);
    }

}
