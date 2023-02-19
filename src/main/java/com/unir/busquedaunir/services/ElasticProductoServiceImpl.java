package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticProducto;
import com.unir.busquedaunir.models.request.CreateProductRequest;
import com.unir.busquedaunir.repositories.ElasticsearchProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ElasticProductoServiceImpl implements ElasticProductoService{

    private final ElasticsearchProductoRepository repo;

    @Override
    public ElasticProducto getProductById(String productId) {
        return repo.getById(productId);
    }

 /*   @Override
    public ElasticProducto getProductByName(String productName) {
        return repo.getByName(productName);
    }*/

    @Override
    public List<ElasticProducto> searchByCodigo(String codigo) {
        return repo.searchByCodigo(codigo);
    }

    @Override
    public List<ElasticProducto> searchByCodigoExacto(String codigo) {
        return repo.searchByCodigoExacto(codigo);
    }


    @Override
    public List<ElasticProducto> searchByName(String productName) {
        return repo.searchByName(productName);
    }

    @Override
    public List<ElasticProducto> getAvailableProducts() {
        Iterable<ElasticProducto> productos= repo.getAll();
        List<ElasticProducto> p = new ArrayList<>();
        for(ElasticProducto producto: productos){
            p.add(producto);
        }
        return p;
    }


    @Override
    public ElasticProducto createProduct(CreateProductRequest request) {

        if (request != null && StringUtils.hasLength(request.getNombre())
                && StringUtils.hasLength(request.getCodigo().trim())
                ) {

            ElasticProducto product =
                    ElasticProducto.builder().id(String.valueOf(request.getNombre().hashCode()))
                            .nombre(request.getNombre()).codigo(request.getCodigo()).precio(request.getPrecio())
                            .cantidad(request.getCantidad()).build();

            return repo.saveProduct(product);
        } else {
            return null;
        }
    }

}
