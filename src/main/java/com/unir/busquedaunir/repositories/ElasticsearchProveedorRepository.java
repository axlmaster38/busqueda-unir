package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticProveedor;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ElasticsearchProveedorRepository {

    private final String[] nameSearchFields =
            {"nombre.search", "nombre.search._2gram", "nombre.search._3gram"};

    private final ElasticProveedorRepository proveedorRepository;
    private final ElasticsearchOperations elasticClient;

    public ElasticProveedor getById(String id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Iterable<ElasticProveedor> getAll(){
        return  proveedorRepository.findAll();
    }
  /*  public ElasticProveedor getByName(String name) {
        return proveedorRepository.findByName(name).orElse(null);
    }*/


    public List<ElasticProveedor> searchByName(String namePart) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.multiMatchQuery(namePart, nameSearchFields)
                .type(MultiMatchQueryBuilder.Type.BOOL_PREFIX));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticProveedor> result = elasticClient.search(query, ElasticProveedor.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public List<ElasticProveedor> searchByNombreExacto(String nombre) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.matchQuery("nombre", nombre));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticProveedor> result = elasticClient.search(query, ElasticProveedor.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }


    public ElasticProveedor saveProveedor(ElasticProveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

}
