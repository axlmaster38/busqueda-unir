package com.unir.busquedaunir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.busquedaunir.entities.CategoriaEntity;
import com.unir.busquedaunir.models.Dto.CategoriaDto;
import com.unir.busquedaunir.services.CategoriaServiceImpl;

@RestController

@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaServiceImpl categoriaService;

	

	@PostMapping
    public ResponseEntity<?> getCategoria(@RequestBody CategoriaDto categoriaDto){
        String body = "Ingresa algun valor de busqueda";
        List<CategoriaEntity> categoriaEntities = categoriaService.getCategoria(categoriaDto);
        if(categoriaEntities != null)
            return new ResponseEntity<>(categoriaEntities,null, HttpStatus.OK );
        else
            return new ResponseEntity<>(body, null, HttpStatus.NO_CONTENT);
    }

	
}
