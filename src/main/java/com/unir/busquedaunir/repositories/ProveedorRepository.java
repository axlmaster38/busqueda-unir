package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ProveedorEntity;
import com.unir.busquedaunir.models.enums.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Integer> {

    List<ProveedorEntity> findByNombre(String nombre);
    List<ProveedorEntity> findByApellido(String apellido);
    List<ProveedorEntity> findByTipoDocumento(TipoDocumento tipoDocumento);
    List<ProveedorEntity> findByDocumento(String documento);
    List<ProveedorEntity> findByTelefono(String telefono);
    List<ProveedorEntity> findByEmail(String email);
    List<ProveedorEntity> findByDireccion(String direccion);
    List<ProveedorEntity> findByEmpresa(String empresa);


}
