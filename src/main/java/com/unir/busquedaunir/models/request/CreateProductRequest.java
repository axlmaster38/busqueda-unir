package com.unir.busquedaunir.models.request;

import com.unir.busquedaunir.entities.ElasticCategoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

	private int id;
	private String nombre;
	private String codigo;
	private int cantidad;
	private int precio;
	private String estado;
	private String unidad;
	private ElasticCategoria categoria;

}
