package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticCompra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticCompraRepository extends ElasticsearchRepository<ElasticCompra, String> {


}