package com.unir.busquedaunir.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Venta")  //Keyword en H2 de User
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaEntity implements Serializable {


    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private int numeroFactura;
    @Column(nullable = false)
    private int total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity usuario;


    @JoinTable(
            name = "ProductoVenta",
            joinColumns = @JoinColumn(name = "venta_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="producto_id", nullable = false)
    )
    @ManyToMany //(cascade = CascadeType.MERGE)
    private List<ProductoEntity> productos;

    private Date fechaCreacion;
    private String usuarioCreacion;
    private Date fechaModificacion;
    private String usuarioModificacion;

}
