package com.unir.busquedaunir.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.busquedaunir.entities.ClienteEntity;
import com.unir.busquedaunir.models.enums.TipoDocumento;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
	List<ClienteEntity> findByNombre(String nombre);

	List<ClienteEntity> findByApellido(String apellido);

	List<ClienteEntity> findByTipoDocumento(TipoDocumento tipoDocumento);

	List<ClienteEntity> findByDocumento(String documento);

	List<ClienteEntity> findByTelefono(String telefono);

	List<ClienteEntity> findByEmail(String email);

}
