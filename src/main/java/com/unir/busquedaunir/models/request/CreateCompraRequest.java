package com.unir.busquedaunir.models.request;

import com.unir.busquedaunir.entities.ElasticProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompraRequest {

	private int id;
	private Date fecha;
	private String numeroFactura;
	private int total;
	private int proveedor_id;
	private List<ElasticProducto> productos;


}
