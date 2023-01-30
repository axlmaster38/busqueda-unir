package com.unir.busquedaunir.services;

import java.util.List;

import com.unir.busquedaunir.models.response.ProductoResponse;

public interface ProductoService {

	

	public List<ProductoResponse> getProducto(String texto);

	public List<ProductoResponse> getAll();

	

}
