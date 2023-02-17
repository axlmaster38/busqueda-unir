package com.unir.busquedaunir.repositories;

import com.unir.busquedaunir.entities.ElasticCategoria;
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
public class ElasticsearchCategoriaRepository {

    private final String[] nameSearchFields =
            {"nombre.search", "nombre.search._2gram", "nombre.search._3gram"};

    private final ElasticCategoriaRepository categoriaRepository;
    private final ElasticsearchOperations elasticClient;

    public ElasticCategoria getById(String id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Iterable<ElasticCategoria> getAll(){
        return  categoriaRepository.findAll();
    }
  /*  public ElasticCategoria getByName(String name) {
        return categoriaRepository.findByName(name).orElse(null);
    }*/


    public List<ElasticCategoria> searchByName(String namePart) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.multiMatchQuery(namePart, nameSearchFields)
                .type(MultiMatchQueryBuilder.Type.BOOL_PREFIX));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticCategoria> result = elasticClient.search(query, ElasticCategoria.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public List<ElasticCategoria> searchByNombreExacto(String codigo) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.matchQuery("nombre", codigo));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticCategoria> result = elasticClient.search(query, ElasticCategoria.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

    public List<ElasticCategoria> searchByDescription(String description) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.matchQuery("descripcion", description));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<ElasticCategoria> result = elasticClient.search(query, ElasticCategoria.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }


    public ElasticCategoria saveCategoria(ElasticCategoria categoria) {
        return categoriaRepository.save(categoria);
    }

}
