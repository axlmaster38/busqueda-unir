package com.unir.busquedaunir.entities;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

import javax.persistence.Id;

@Document(indexName = "cliente", createIndex = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElasticCliente {


    @Id
    private String id;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "nombre"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String nombre;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "apellido"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String apellido;

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

}
