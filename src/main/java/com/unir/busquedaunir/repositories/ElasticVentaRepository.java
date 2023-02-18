package com.unir.busquedaunir.repositories;


import com.unir.busquedaunir.entities.ElasticVenta;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticVentaRepository extends ElasticsearchRepository<ElasticVenta, String> {


}