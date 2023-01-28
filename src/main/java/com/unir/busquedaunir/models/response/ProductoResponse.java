package com.unir.busquedaunir.models.response;

import com.unir.busquedaunir.entities.CategoriaEntity;
import com.unir.busquedaunir.models.Dto.CategoriaDto;
import com.unir.busquedaunir.models.enums.Estado;
import com.unir.busquedaunir.models.enums.TipoUnidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse {

	 private int id;
	    private String nombre;
	    private String codigo;
	    private int precio;
	    private Estado estado;
	    private TipoUnidad unidad;
	    private int cantidad;
	    private CategoriaDto categoria;
	
}
