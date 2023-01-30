package com.unir.busquedaunir.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Compra")  //Keyword en H2 de User
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraEntity implements Serializable {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private Date fecha_creacion;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private int numeroFactura;
    @Column(nullable = false)
    private int total;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity usuario;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoEntity producto;

    @Column(nullable = false)
    private String usuario_creacion;
    @Column(nullable = false)
    private Date fecha_modificacion;
    @Column(nullable = false)
    private String usuario_modificacion;

}
