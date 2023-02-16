package com.unir.busquedaunir.entities;

import com.unir.busquedaunir.models.enums.Estado;
import com.unir.busquedaunir.models.enums.TipoUnidad;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

import javax.persistence.*;


@Document(indexName = "producto", createIndex = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElasticProducto {


    @Id
    private String id;

    @MultiField(mainField = @Field(type= FieldType.Keyword, name="nombre"),
    otherFields=@InnerField(suffix = "search", type=FieldType.Search_As_You_Type)
    )
    private String nombre;

    @Field(type = FieldType.Keyword, name = "codigo")
    private String codigo;


    @Field(type = FieldType.Integer, name="cantidad")
    private int cantidad;

    @Field(type = FieldType.Integer, name="precio")
    private int precio;

   /* @Field(type = FieldType.Integer, name="estado")
    private int estado;

    @Field(type = FieldType.Integer, name="categoria_id")
    private int categoria_id;

    @Field(type = FieldType.Integer, name="unidad")
    private int unidad;*/

}