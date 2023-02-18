package com.unir.busquedaunir.models.request;

import com.unir.busquedaunir.entities.ElasticProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateVentaRequest {


    private String fecha;
    private int cliente_id;
    private String numeroFactura;
    private int total;
    private List<ElasticProducto> productos;


}
