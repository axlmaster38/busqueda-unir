package com.unir.busquedaunir.entities;


import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

import org.springframework.data.annotation.Id;

@Document(indexName = "producto", createIndex = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElasticProducto {


    @Id
    private int id;

    @MultiField(mainField = @Field(type= FieldType.Keyword, name="nombre"),
    otherFields=@InnerField(suffix = "search", type=FieldType.Search_As_You_Type)
    )
    private String nombre;

    @MultiField(mainField = @Field(type= FieldType.Keyword, name="codigo"),
            otherFields=@InnerField(suffix = "search", type=FieldType.Search_As_You_Type)
    )
    private String codigo;


    @Field(type = FieldType.Integer, name="cantidad")
    private int cantidad;

    @Field(type = FieldType.Integer, name="precio")
    private int precio;

    @Field(type = FieldType.Text, name="estado")
    private String estado;

    @Field(type = FieldType.Object, name="categoria")
    private ElasticCategoria categoria;

    @Field(type = FieldType.Text, name="unidad")
    private String unidad;

}
