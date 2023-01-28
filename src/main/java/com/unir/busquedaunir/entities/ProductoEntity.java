package com.unir.busquedaunir.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.unir.busquedaunir.models.enums.Estado;
import com.unir.busquedaunir.models.enums.TipoUnidad;

import java.io.Serializable;

@Entity(name = "Producto")  
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductoEntity implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = true, length = 3)
    private String codigo;
    @Column(nullable = false, length = 100)
    private int cantidad;
    @Column(nullable = false, length = 100)
    private int precio;
    @Column(nullable = false)
    private Estado estado;
    @Column(nullable = false)
    private TipoUnidad unidad;
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="categoriaId")
    private CategoriaEntity categoria;
    

}
