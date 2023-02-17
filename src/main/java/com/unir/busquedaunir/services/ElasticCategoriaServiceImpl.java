package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticCategoria;
import com.unir.busquedaunir.entities.ElasticCategoria;
import com.unir.busquedaunir.models.request.CreateCategoriaRequest;
import com.unir.busquedaunir.repositories.ElasticsearchCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ElasticCategoriaServiceImpl implements ElasticCategoriaService{

    private final ElasticsearchCategoriaRepository repo;

    @Override
    public ElasticCategoria createCategoria(CreateCategoriaRequest request) {

        if (request != null && StringUtils.hasLength(request.getNombre())
                && StringUtils.hasLength(request.getDescripcion().trim())
        ) {

            ElasticCategoria categoria =
                    ElasticCategoria.builder().id(String.valueOf(request.getNombre().hashCode()))
                            .nombre(request.getNombre()).descripcion(request.getDescripcion()).estado(request.getEstado())
                            .build();

            return repo.saveCategoria(categoria);
        } else {
            return null;
        }
    }

    @Override
    public ElasticCategoria getCategoriaById(String categoriaoId) {
        return repo.getById(categoriaoId);
    }

    @Override
    public List<ElasticCategoria> searchByNombreExacto(String nombre) {
        return repo.searchByNombreExacto(nombre);
    }

    @Override
    public List<ElasticCategoria> searchByName(String categoriaName) {
        return repo.searchByName(categoriaName);
    }

    @Override
    public List<ElasticCategoria> searchByDescription(String descripcion) {
        return repo.searchByDescription(descripcion);
    }

    @Override
    public List<ElasticCategoria> getAvailableCategorias() {
        Iterable<ElasticCategoria> categorias= repo.getAll();
        List<ElasticCategoria> p = new ArrayList<>();
        for(ElasticCategoria categoria: categorias){
            p.add(categoria);
        }
        return p;
    }
}
