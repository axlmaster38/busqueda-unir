package com.unir.busquedaunir.services;

import java.util.List;

import com.unir.busquedaunir.entities.CompraEntity;
import com.unir.busquedaunir.models.Dto.CompraDto;

public interface CompraService {
	 public List<CompraEntity> getCompra(CompraDto compraDto);
}
