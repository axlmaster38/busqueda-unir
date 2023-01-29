package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ProveedorEntity;
import com.unir.busquedaunir.models.Dto.ProveedorDto;

import java.util.List;

public interface ProveedorService {

    public List<ProveedorEntity> getProveedor(ProveedorDto proveedorDto);

}
