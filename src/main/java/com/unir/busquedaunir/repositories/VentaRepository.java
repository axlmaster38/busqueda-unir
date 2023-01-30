package com.unir.busquedaunir.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.busquedaunir.entities.VentaEntity;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Integer> {
	List<VentaEntity> findByFecha(Date fecha);
    List<VentaEntity> findByNumeroFactura(Integer numero_factura);
    List<VentaEntity> findBytotal(Integer total);
    List<VentaEntity> findByCliente_id(Integer cliente_id);
}
