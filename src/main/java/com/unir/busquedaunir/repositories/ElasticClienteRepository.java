package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticCliente;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticClienteRepository extends ElasticsearchRepository<ElasticCliente, String> {


}