package com.unir.busquedaunir.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.busquedaunir.entities.CompraEntity;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Integer> {
	List<CompraEntity> findByFecha(Date fecha);
    List<CompraEntity> findByNumeroFactura(Integer numeroFactura);
    List<CompraEntity> findBytotal(Integer total);
    List<CompraEntity> findByProveedor_id(Integer proveedor_id);
    
}