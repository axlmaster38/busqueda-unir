package com.unir.busquedaunir.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoriaRequest {

	private String nombre;
	private String descripcion;
	private String estado;


}
