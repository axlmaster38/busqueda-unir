package com.unir.busquedaunir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.busquedaunir.models.Dto.CategoriaDto;
import com.unir.busquedaunir.services.CategoriaServiceImpl;

@RestController

@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaServiceImpl categoriaService;

	@GetMapping("/{id}")
	public CategoriaDto getCategoria(@PathVariable int id) {
		return categoriaService.getCategoria(id);

	}

	@PostMapping
	public CategoriaDto createCategoria(@RequestBody CategoriaDto categoriaDto) {
		return categoriaService.createCategoria(categoriaDto);

	}

	@GetMapping
	public List<CategoriaDto> getAll() {
		return categoriaService.getAll();
	}

	@PutMapping
	public CategoriaDto editCategoria(@RequestBody CategoriaDto categoriaDto) {
		
		return categoriaService.editCategoria(categoriaDto);
		
	}

	@PatchMapping
	public CategoriaDto updateCategoria(@RequestBody CategoriaDto categoriaDto) {
		
		return categoriaService.updateEstado(categoriaDto);
	}
}
