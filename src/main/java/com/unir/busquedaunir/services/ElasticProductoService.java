package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticProducto;
import com.unir.busquedaunir.models.request.CreateProductRequest;

import java.util.List;

public interface  ElasticProductoService {

    ElasticProducto createProduct(CreateProductRequest request);
    ElasticProducto getProductById(String productoId);
    //ElasticProducto getProductByName(String productName);
    List<ElasticProducto> searchByCodigo(String codigo);
    List<ElasticProducto> searchByCodigoExacto(String codigo);
    List<ElasticProducto> searchByName(String productName);
    List<ElasticProducto> getAvailableProducts();
}
