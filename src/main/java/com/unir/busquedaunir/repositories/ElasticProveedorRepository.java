package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticProveedor;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticProveedorRepository extends ElasticsearchRepository<ElasticProveedor, String> {


}