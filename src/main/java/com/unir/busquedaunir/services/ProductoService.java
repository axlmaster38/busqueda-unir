package com.unir.busquedaunir.services;

import com.unir.busquedaunir.models.Dto.ProductoDto;
import com.unir.busquedaunir.models.response.ProductoResponse;

import java.util.List;

public interface ProductoService {

	

	public List<ProductoResponse> getProducto(String texto);

	public List<ProductoResponse> getAll();

	

}
