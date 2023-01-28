package com.unir.busquedaunir.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.busquedaunir.entities.CategoriaEntity;
import com.unir.busquedaunir.entities.ProductoEntity;
import com.unir.busquedaunir.models.Dto.CategoriaDto;
import com.unir.busquedaunir.models.Dto.ProductoDto;
import com.unir.busquedaunir.repositories.CategoriaRepository;
import com.unir.busquedaunir.repositories.ProductoRepository;
import com.unir.busquedaunir.models.response.ProductoResponse;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<ProductoResponse> getProducto(String texto) {
		texto=texto.toLowerCase();
		String palabrasclaves[] = { "pollo", "pescado", "chiguiro", "vaca", "lomo", "res", "pechuga" };
		ArrayList<String> listadoBusqueda = new ArrayList<String>();

		for (String clave : palabrasclaves) {
			if (texto.contains(clave)) {
				listadoBusqueda.add(clave);
			}
		}

		for (String palabraB : listadoBusqueda) {
			System.out.println(palabraB);
		}
		String[] textoArreglo = texto.split(" ");
		List<ProductoEntity> productoEntity = productoRepository.findAll();
		List<ProductoResponse> productos = new ArrayList<>();
		for (ProductoEntity producto : productoEntity) {
			ProductoResponse response = new ProductoResponse();
			CategoriaDto categoriaDto = new CategoriaDto();
			Optional<CategoriaEntity> categoriaEntitiy = categoriaRepository.findById(producto.getCategoria().getId());
			BeanUtils.copyProperties(categoriaEntitiy.get(), categoriaDto);
			BeanUtils.copyProperties(producto, response);
			response.setCategoria(categoriaDto);
			for (String palabraB : listadoBusqueda) {
				if (response.getNombre().toLowerCase().contains(palabraB) || response.getCategoria().getDescripcion().toLowerCase().contains(palabraB)
						|| response.getCategoria().getNombre().toLowerCase().contains(palabraB)) {
					productos.add(response);
					break;
				}
				for (String palabra : textoArreglo) {
					if (palabra.chars().allMatch(Character::isDigit)) {
						if (Integer.toString(response.getPrecio()).contains(palabra)) {
							productos.add(response);
						}
					}
				}
			}
			if (listadoBusqueda.isEmpty()) {
				if ((texto.contains("carne"))&&( response.getNombre().contains("carne") || response.getCodigo().contains("carne")
						|| response.getCategoria().getDescripcion().contains("carne")
						|| response.getCategoria().getNombre().contains("carne"))) {
					productos.add(response);
					
				}
				
				for (String palabra : textoArreglo) {
					if (palabra.chars().allMatch(Character::isDigit)) {
						if (Integer.toString(response.getPrecio()).contains(palabra)) {
							productos.add(response);
						}
					}
				}
			}
			if (texto.contains(response.getCodigo().toLowerCase())) {
				productos.add(response);
			}
		}
		return productos;
	}

	@Override
	public List<ProductoResponse> getAll() {
		List<ProductoEntity> productoEntity = productoRepository.findAll();
		List<ProductoResponse> productos = new ArrayList<>();
		for (ProductoEntity producto : productoEntity) {
			ProductoResponse response = new ProductoResponse();
			CategoriaDto categoriaDto = new CategoriaDto();
			Optional<CategoriaEntity> categoriaEntitiy = categoriaRepository.findById(producto.getCategoria().getId());
			BeanUtils.copyProperties(categoriaEntitiy.get(), categoriaDto);
			BeanUtils.copyProperties(producto, response);
			response.setCategoria(categoriaDto);
			productos.add(response);
		}
		return productos;

	}

}
