package com.unir.busquedaunir.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "ProductoVenta")  //Keyword en H2 de User
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoVentaEntity implements Serializable {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int venta_id;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private int producto_id;

    @Column(nullable = false)
    private int precio;

    private Date fechaCreacion;
    private String usuarioCreacion;
    private Date fechaModificacion;
    private String usuarioModificacion;


    @Override
    public String toString() {
        return "ProductoVentaEntity{" +
                "id=" + id +
                ", venta_id=" + venta_id +
                ", cantidad=" + cantidad +
                ", producto_id=" + producto_id +
                ", precio=" + precio +
                ", fechaCreacion=" + fechaCreacion +
                ", usuarioCreacion='" + usuarioCreacion + '\'' +
                ", fechaModificacion=" + fechaModificacion +
                ", usuarioModificacion='" + usuarioModificacion + '\'' +
                '}';
    }
}
