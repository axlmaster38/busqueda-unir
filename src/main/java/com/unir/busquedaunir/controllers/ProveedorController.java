package com.unir.busquedaunir.controllers;

import com.unir.busquedaunir.entities.ProveedorEntity;
import com.unir.busquedaunir.models.Dto.ProveedorDto;
import com.unir.busquedaunir.services.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorServiceImpl proveedorService;

    @PostMapping
    public ResponseEntity<?> getProveedor(@RequestBody ProveedorDto proveedorDto){
        String body = "Ingresa algun valor de busqueda";
        List<ProveedorEntity> proveedorEntities = proveedorService.getProveedor(proveedorDto);
        if(proveedorEntities != null)
            return new ResponseEntity<>(proveedorEntities,null, HttpStatus.OK );
        else
            return new ResponseEntity<>(body, null, HttpStatus.NO_CONTENT);
    }



}
