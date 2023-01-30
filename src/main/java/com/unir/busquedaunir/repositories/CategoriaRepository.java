package com.unir.busquedaunir.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.busquedaunir.entities.CategoriaEntity;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {

	List<CategoriaEntity> findByNombre(String nombre);
    List<CategoriaEntity> findByDescripcion(String descripcion);
    
}
