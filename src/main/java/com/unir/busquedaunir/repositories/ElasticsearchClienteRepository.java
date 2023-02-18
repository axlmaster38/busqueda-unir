package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticCliente;
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
public class ElasticsearchClienteRepository {

    private final String[] nameSearchFields =
            {"nombre.search", "nombre.search._2gram", "nombre.search._3gram"};

    private final ElasticClienteRepository clienteRepository;
    private final ElasticsearchOperations elasticClient;

    public ElasticCliente getById(String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Iterable<ElasticCliente> getAll(){
        return  clienteRepository.findAll();
    }
  /*  public ElasticCliente getByName(String name) {
        return clienteRepository.findByName(name).orElse(null);
    }*/


    public List<ElasticCliente> searchByName(String namePart) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.multiMatchQuery(namePart, nameSearchFields)
                .type(MultiMatchQueryBuilder.Type.BOOL_PREFIX));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticCliente> result = elasticClient.search(query, ElasticCliente.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public List<ElasticCliente> searchByNombreExacto(String nombre) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.matchQuery("nombre", nombre));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticCliente> result = elasticClient.search(query, ElasticCliente.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }


    public ElasticCliente saveCliente(ElasticCliente cliente) {
        return clienteRepository.save(cliente);
    }

}
