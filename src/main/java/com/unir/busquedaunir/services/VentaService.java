package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.VentaEntity;
import com.unir.busquedaunir.models.Dto.VentaDto;



import java.util.List;

public interface VentaService {


	public List<VentaEntity> getVenta(VentaDto ventaDto);

}
