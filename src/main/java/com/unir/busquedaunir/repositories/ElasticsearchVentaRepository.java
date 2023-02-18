package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticVenta;
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
public class ElasticsearchVentaRepository {

    private final String[] numeroFacturaSearchFields =

            {"numeroFactura.search", "numeroFactura.search._2gram", "numeroFactura.search._3gram"};

    private final ElasticVentaRepository ventaRepository;
    private final ElasticsearchOperations elasticClient;

    public ElasticVenta getById(String id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public Iterable<ElasticVenta> getAll(){
        return  ventaRepository.findAll();
    }
  /*  public ElasticVenta getByName(String name) {
        return ventaRepository.findByName(name).orElse(null);
    }*/


    public List<ElasticVenta> searchByFactura(String namePart) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.multiMatchQuery(namePart, numeroFacturaSearchFields)
                .type(MultiMatchQueryBuilder.Type.BOOL_PREFIX));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticVenta> result = elasticClient.search(query, ElasticVenta.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public List<ElasticVenta> searchByFacturaExacto(String fecha) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.matchQuery("fecha", fecha));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticVenta> result = elasticClient.search(query, ElasticVenta.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public List<ElasticVenta> searchByFecha(String fecha) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.matchQuery("fecha", fecha));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticVenta> result = elasticClient.search(query, ElasticVenta.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public ElasticVenta saveVenta(ElasticVenta venta) {
        return ventaRepository.save(venta);
    }

}
