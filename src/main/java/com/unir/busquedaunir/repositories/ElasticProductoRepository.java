package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticProducto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface ElasticProductoRepository extends ElasticsearchRepository<ElasticProducto, String> {


}