package com.unir.busquedaunir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.busquedaunir.entities.VentaEntity;
import com.unir.busquedaunir.models.Dto.VentaDto;
import com.unir.busquedaunir.repositories.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository ventaRepository;

	@Override
	public List<VentaEntity> getVenta(VentaDto ventaDto) {
		if (ventaDto.getFecha() != null)
			return ventaRepository.findByFecha(ventaDto.getFecha());
		if (ventaDto.getNumero_factura() != 0)
			return ventaRepository.findByNumeroFactura(ventaDto.getNumero_factura());
		if (ventaDto.getTotal() != 0)
			return ventaRepository.findBytotal(ventaDto.getTotal());
		if (ventaDto.getCliente_id() != 0)
			return ventaRepository.findByCliente_id(ventaDto.getCliente_id());

		return null;
	}
}
