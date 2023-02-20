package com.unir.busquedaunir.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Document(indexName = "categoria", createIndex = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElasticCategoria {

  @Id
  private int id;

  @MultiField(mainField = @Field(type = FieldType.Keyword, name = "nombre"),
      otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type))
  private String nombre;

  @Field(type = FieldType.Text, name = "descripcion")
  private String descripcion;

  @Field(type = FieldType.Text, name="estado")
  private String estado;

}
