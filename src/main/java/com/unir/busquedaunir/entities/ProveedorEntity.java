package com.unir.busquedaunir.entities;

import com.unir.busquedaunir.models.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Proveedor")  //Keyword en H2 de User
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorEntity implements Serializable {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellido;
    private TipoDocumento tipoDocumento;
    @Column(nullable = false, length = 20)
    private String documento;
    @Column(nullable = false, length = 20)
    private String telefono;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String direccion;
    @Column(nullable = false, length = 100)
    private String empresa;
    private Date fechaCreación;
    private String usuarioCreacion;
    private Date fechaModificacion;
    private String usuarioModificacion;

}
