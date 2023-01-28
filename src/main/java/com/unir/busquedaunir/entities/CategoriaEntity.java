package com.unir.busquedaunir.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import javax.persistence.*;

import com.unir.busquedaunir.models.Dto.ProductoDto;
import com.unir.busquedaunir.models.enums.Estado;

import java.io.Serializable;
import java.util.List;

@Entity(name = "Categoria")  
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CategoriaEntity implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = true, length = 100)
    private String descripcion;
    @Column(nullable = false)
    private Estado estado;
    @OneToMany(mappedBy="categoria")
    private List<ProductoEntity> productos= new ArrayList<>();
    

}
