package com.unir.busquedaunir.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateClienteRequest {

	private int id;
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private String documento;
	private String telefono;
	private String email;
	private String direccion;

}
