package com.unir.busquedaunir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.busquedaunir.models.response.ProductoResponse;
import com.unir.busquedaunir.services.ProductoServiceImpl;

@RestController

@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoService;

	@GetMapping("/{texto}")
	public  List<ProductoResponse> getProducto(@PathVariable String texto) {
		return productoService.getProducto(texto);

	}

	
	@GetMapping
	public List<ProductoResponse> getAll() {
		return productoService.getAll();
	}
	
	

	
}
