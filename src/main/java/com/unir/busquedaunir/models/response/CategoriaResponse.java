package com.unir.busquedaunir.models.response;

import com.unir.busquedaunir.entities.ProductoEntity;
import com.unir.busquedaunir.models.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponse {

	private int id;
	private String nombre;
	private String descripcion;
	private Estado estado;
	private ProductoEntity producto;

}
