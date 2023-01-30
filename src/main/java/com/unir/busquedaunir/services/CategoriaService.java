package com.unir.busquedaunir.services;

import java.util.List;

import com.unir.busquedaunir.entities.CategoriaEntity;
import com.unir.busquedaunir.models.Dto.CategoriaDto;

public interface CategoriaService {

	 public List<CategoriaEntity> getCategoria(CategoriaDto categoriaDto);

}
