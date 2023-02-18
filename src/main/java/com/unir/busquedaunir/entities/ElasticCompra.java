package com.unir.busquedaunir.entities;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

import org.springframework.data.annotation.Id;
import java.util.Date;
import java.util.List;

@Document(indexName = "compra", createIndex = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElasticCompra {

    @Id
    private int id;

    //@Field(type = FieldType.Date, name = "fecha")
    @Field(type = FieldType.Keyword, name = "fecha")
    private Date fecha;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "numeroFactura"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
   // @Field(type = FieldType.Text, name="numeroFactura")
    private String numeroFactura;

    @Field(type = FieldType.Integer, name="total")
    private int total;

    @Field(type = FieldType.Integer, name="proveedor_id")
    private int proveedor_id;

    @Field(type = FieldType.Object, name="total")
    private List<ElasticProducto> productos;


}
