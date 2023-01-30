package com.unir.busquedaunir.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.busquedaunir.entities.CompraEntity;
import com.unir.busquedaunir.models.Dto.CompraDto;
import com.unir.busquedaunir.repositories.CompraRepository;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;
   
    @Override
    public List<CompraEntity> getCompra(CompraDto compraDto) {
        if(compraDto.getFecha_creacion() != null)
            return compraRepository.findByFecha(compraDto.getFecha());
        if(compraDto.getNumero_factura() != 0)
            return compraRepository.findByNumeroFactura( compraDto.getNumero_factura());
        if(compraDto.getTotal() != 0)
            return compraRepository.findBytotal(compraDto.getTotal());
        if(compraDto.getProveedor_id() != 0)
            return compraRepository.findByProveedor_id( compraDto.getProveedor_id());
       

        return null;
    }
   
}