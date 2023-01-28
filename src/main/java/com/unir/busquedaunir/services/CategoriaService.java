package com.unir.busquedaunir.services;

import com.unir.busquedaunir.models.Dto.CategoriaDto;

import java.util.List;

public interface CategoriaService {

	public CategoriaDto createCategoria(CategoriaDto categoriaDto);

	public CategoriaDto getCategoria(int id);

	public List<CategoriaDto> getAll();

	public CategoriaDto editCategoria(CategoriaDto categoriaDto);

	public CategoriaDto updateEstado(CategoriaDto categoriaDto);

}
