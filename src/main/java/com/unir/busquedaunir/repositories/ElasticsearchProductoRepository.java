package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticProducto;
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
import java.util.stream.Collectors;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ElasticsearchProductoRepository {

    private final String[] nameSearchFields =
            {"nombre.search", "nombre.search._2gram", "nombre.search._3gram"};

    private final String[]  codigoSearchFields=
            {"codigo.search", "codigo.search._2gram", "codigo.search._3gram"};

    private final ElasticProductoRepository productRepository;
    private final ElasticsearchOperations elasticClient;

    public ElasticProducto getById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Iterable<ElasticProducto> getAll(){
        return  productRepository.findAll();
    }
  /*  public ElasticProducto getByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }*/


    public List<ElasticProducto> searchByName(String namePart) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.multiMatchQuery(namePart, nameSearchFields)
                .type(MultiMatchQueryBuilder.Type.BOOL_PREFIX));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticProducto> result = elasticClient.search(query, ElasticProducto.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public List<ElasticProducto> searchByCodigoExacto(String codigo) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.matchQuery("codigo", codigo));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticProducto> result = elasticClient.search(query, ElasticProducto.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public List<ElasticProducto> searchByCodigo(String namePart) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.multiMatchQuery(namePart, codigoSearchFields)
                .type(MultiMatchQueryBuilder.Type.BOOL_PREFIX));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticProducto> result = elasticClient.search(query, ElasticProducto.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }
    public ElasticProducto saveProduct(ElasticProducto product) {
        return productRepository.save(product);
    }

}
