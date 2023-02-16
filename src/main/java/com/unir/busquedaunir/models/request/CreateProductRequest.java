package com.unir.busquedaunir.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

	private String nombre;
	private String codigo;
	private int cantidad;
	private int precio;

}
