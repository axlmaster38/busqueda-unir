package com.unir.busquedaunir.entities;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

import javax.persistence.Id;

@Document(indexName = "proveedor", createIndex = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElasticProveedor {


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
    private String tipoDocumento;
    private String documento;
    private String telefono;
    private String email;
    private String direccion;
    private String empresa;
}
