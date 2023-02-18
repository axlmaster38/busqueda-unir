package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticCompra;
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
public class ElasticsearchCompraRepository {

    private final String[] numeroFacturaSearchFields =

            {"numeroFactura.search", "numeroFactura.search._2gram", "numeroFactura.search._3gram"};

    private final ElasticCompraRepository compraRepository;
    private final ElasticsearchOperations elasticClient;

    public ElasticCompra getById(String id) {
        return compraRepository.findById(id).orElse(null);
    }

    public Iterable<ElasticCompra> getAll(){
        return  compraRepository.findAll();
    }
  /*  public ElasticCompra getByName(String name) {
        return compraRepository.findByName(name).orElse(null);
    }*/


    public List<ElasticCompra> searchByFactura(String namePart) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.multiMatchQuery(namePart, numeroFacturaSearchFields)
                .type(MultiMatchQueryBuilder.Type.BOOL_PREFIX));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticCompra> result = elasticClient.search(query, ElasticCompra.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public List<ElasticCompra> searchByFacturaExacto(String fecha) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.matchQuery("fecha", fecha));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticCompra> result = elasticClient.search(query, ElasticCompra.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public List<ElasticCompra> searchByFecha(String fecha) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.matchQuery("fecha", fecha));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticCompra> result = elasticClient.search(query, ElasticCompra.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public ElasticCompra saveCompra(ElasticCompra compra) {
        return compraRepository.save(compra);
    }

}
