package com.unir.busquedaunir.entities;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

import org.springframework.data.annotation.Id;

@Document(indexName = "proveedor", createIndex = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElasticProveedor {


    @Id
    private int id;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "nombre"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String nombre;

    @Field(type = FieldType.Text, name="estado")
    private String estado;

    @Field(type = FieldType.Text, name="tipoDocumento")
    private String tipoDocumento;

    @Field(type = FieldType.Text, name="documento")
    private String documento;

    @Field(type = FieldType.Text, name="telefono")
    private String telefono;

    @Field(type = FieldType.Text, name="email")
    private String email;

    @Field(type = FieldType.Text, name="direccion")
    private String direccion;

    @Field(type = FieldType.Text, name="descripcion")
    private String descripcion;
}
