package com.unir.busquedaunir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.busquedaunir.entities.CategoriaEntity;
import com.unir.busquedaunir.models.Dto.CategoriaDto;
import com.unir.busquedaunir.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	 public List<CategoriaEntity> getCategoria(CategoriaDto categoriaDto) {
	        if(categoriaDto.getNombre() != null)
	            return categoriaRepository.findByNombre(categoriaDto.getNombre());
	        if(categoriaDto.getDescripcion() != null)
	            return categoriaRepository.findByDescripcion( categoriaDto.getDescripcion());
	       

	        return null;
	    }
	
	
}
