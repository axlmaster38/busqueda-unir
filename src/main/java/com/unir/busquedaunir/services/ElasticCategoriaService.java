package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticCategoria;
import com.unir.busquedaunir.models.request.CreateCategoriaRequest;

import java.util.List;

public interface ElasticCategoriaService {

    ElasticCategoria createCategoria(CreateCategoriaRequest request);
    ElasticCategoria getCategoriaById(String categoriaoId);
    List<ElasticCategoria> searchByNombreExacto(String codigo);
    List<ElasticCategoria> searchByName(String categoriaName);
    List<ElasticCategoria>  searchByDescription (String descripcion);
    List<ElasticCategoria> getAvailableCategorias();
}
