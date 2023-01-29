package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ProveedorEntity;
import com.unir.busquedaunir.models.Dto.ProveedorDto;
import com.unir.busquedaunir.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements  ProveedorService{

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorEntity> getProveedor(ProveedorDto proveedorDto) {
        if(proveedorDto.getNombre() != null)
            return proveedorRepository.findByNombre(proveedorDto.getNombre());
        if(proveedorDto.getApellido() != null)
            return proveedorRepository.findByApellido( proveedorDto.getApellido());
        if(proveedorDto.getTipoDocumento() != null)
            return proveedorRepository.findByTipoDocumento(proveedorDto.getTipoDocumento());
        if(proveedorDto.getDocumento() != null)
            return proveedorRepository.findByDocumento(proveedorDto.getDocumento());
        if(proveedorDto.getTelefono() != null)
            return proveedorRepository.findByTelefono(proveedorDto.getTelefono());
        if(proveedorDto.getDireccion() != null)
            return proveedorRepository.findByDireccion(proveedorDto.getDireccion());
        if(proveedorDto.getEmpresa() != null)
            return proveedorRepository.findByEmpresa(proveedorDto.getEmpresa());

        return null;
    }
}
