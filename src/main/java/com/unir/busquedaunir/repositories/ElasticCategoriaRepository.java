package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticCategoria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticCategoriaRepository extends ElasticsearchRepository<ElasticCategoria, String> {


}