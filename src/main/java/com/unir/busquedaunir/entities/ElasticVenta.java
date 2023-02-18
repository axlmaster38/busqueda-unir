package com.unir.busquedaunir.entities;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

import javax.persistence.Id;
import java.util.List;

@Document(indexName = "venta", createIndex = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElasticVenta {

    @Id
    private String id;

    //@Field(type = FieldType.Date, name = "fecha")
   @Field(type = FieldType.Keyword, name = "fecha")
    private String fecha;

    @Field(type = FieldType.Integer, name="cliente_id")
    private int cliente_id;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "numeroFactura"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
   // @Field(type = FieldType.Text, name="numeroFactura")
    private String numeroFactura;

    @Field(type = FieldType.Integer, name="total")
    private int total;

    @Field(type = FieldType.Object, name="total")
    private List<ElasticProducto> productos;

}
