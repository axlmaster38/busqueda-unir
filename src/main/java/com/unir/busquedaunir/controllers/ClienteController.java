package com.unir.busquedaunir.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.busquedaunir.entities.ClienteEntity;
import com.unir.busquedaunir.models.Dto.ClienteDto;
import com.unir.busquedaunir.services.ClienteServiceImpl;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping
    public ResponseEntity<?> getCliente(@RequestBody ClienteDto clienteDto){
        String body = "Ingresa algun valor de busqueda";
        List<ClienteEntity> clienteEntities = clienteService.getCliente(clienteDto);
        if(clienteEntities != null)
            return new ResponseEntity<>(clienteEntities,null, HttpStatus.OK );
        else
            return new ResponseEntity<>(body, null, HttpStatus.NO_CONTENT);
    }
}
