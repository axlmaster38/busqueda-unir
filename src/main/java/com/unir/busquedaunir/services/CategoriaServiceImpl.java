package com.unir.busquedaunir.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.busquedaunir.entities.CategoriaEntity;
import com.unir.busquedaunir.entities.ProductoEntity;
import com.unir.busquedaunir.models.Dto.CategoriaDto;
import com.unir.busquedaunir.models.Dto.ProductoDto;
import com.unir.busquedaunir.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public CategoriaDto createCategoria(CategoriaDto categoriaDto) {
		CategoriaEntity categoriaEntity = new CategoriaEntity();
        BeanUtils.copyProperties(categoriaDto, categoriaEntity);
        categoriaRepository.save(categoriaEntity);
        return categoriaDto;
	}

	@Override
	public CategoriaDto getCategoria(int id) {
		CategoriaEntity categoriaEntity=categoriaRepository.getById(id);
		CategoriaDto categoriaDto=new CategoriaDto();
		List<ProductoDto> productosDto=new ArrayList<>();
		BeanUtils.copyProperties(categoriaEntity,categoriaDto);
		for (ProductoEntity ProductosEnt : categoriaEntity.getProductos()) {
			ProductoDto productoDto=new ProductoDto();
			BeanUtils.copyProperties(ProductosEnt,productoDto);
			
			productosDto.add(productoDto);
		}
		categoriaDto.setProductos(productosDto);
		return categoriaDto;
	}

	@Override
	public List<CategoriaDto> getAll() {
		List<CategoriaEntity> categoriaEntity=categoriaRepository.findAll();
		List<CategoriaDto> categorias=new ArrayList<>();
		
		for (CategoriaEntity categoria : categoriaEntity) {
			CategoriaDto categoriaDto=new CategoriaDto();
			BeanUtils.copyProperties(categoria,categoriaDto);
			List<ProductoDto> productosDto=new ArrayList<>();
			for (ProductoEntity ProductosEnt : categoria.getProductos()) {
				ProductoDto productoDto=new ProductoDto();
				BeanUtils.copyProperties(ProductosEnt,productoDto);
				
				productosDto.add(productoDto);
			}
			categoriaDto.setProductos(productosDto);
			categorias.add(categoriaDto);
		}
		return categorias;
		 
	}

	@Override
	public CategoriaDto editCategoria(CategoriaDto categoriaDto) {
		CategoriaEntity categoriaEntity=categoriaRepository.getById(categoriaDto.getId());
		List<ProductoDto> productosDto=new ArrayList<>();
		for (ProductoEntity ProductosEnt : categoriaEntity.getProductos()) {
			ProductoDto productoDto=new ProductoDto();
			BeanUtils.copyProperties(ProductosEnt,productoDto);
			
			productosDto.add(productoDto);
		}
		
		BeanUtils.copyProperties(categoriaDto,categoriaEntity);
		categoriaRepository.saveAndFlush(categoriaEntity);
		categoriaDto.setProductos(productosDto);
		return categoriaDto;
	}

	@Override
	public CategoriaDto updateEstado(CategoriaDto categoriaDto) {
		CategoriaEntity categoriaEntity=categoriaRepository.getById(categoriaDto.getId());
		List<ProductoDto> productosDto=new ArrayList<>();
		for (ProductoEntity ProductosEnt : categoriaEntity.getProductos()) {
			ProductoDto productoDto=new ProductoDto();
			BeanUtils.copyProperties(ProductosEnt,productoDto);
			
			productosDto.add(productoDto);
		}
		categoriaEntity.setEstado(categoriaDto.getEstado());
		categoriaRepository.saveAndFlush(categoriaEntity);
		BeanUtils.copyProperties(categoriaDto,categoriaEntity);
		categoriaDto.setProductos(productosDto);
		return categoriaDto;
	}
	
	
}
