package com.unir.busquedaunir.services;

import com.unir.busquedaunir.entities.ElasticCompra;
import com.unir.busquedaunir.entities.ElasticProducto;
import com.unir.busquedaunir.models.request.CreateCompraRequest;
import com.unir.busquedaunir.repositories.ElasticsearchCategoriaRepository;
import com.unir.busquedaunir.repositories.ElasticsearchCompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ElasticCompraServiceImpl implements  ElasticCompraService{

    private final ElasticsearchCompraRepository repo;

    @Override
    public ElasticCompra createCompra(CreateCompraRequest request) {
        if (request != null && StringUtils.hasLength(( request.getFecha().toString()))
                && (request.getProductos().size()>0)
        ) {

            ElasticCompra compra =
                    ElasticCompra.builder().id(String.valueOf(request.getNumeroFactura()).hashCode())
                            .fecha(request.getFecha()).numeroFactura(request.getNumeroFactura()).total(request.getTotal())
                            .proveedor_id(request.getProveedor_id())
                            .productos(request.getProductos()).build();

            return repo.saveCompra(compra);
        } else {
            return null;
        }
    }

    @Override
    public ElasticCompra getCompraById(String compraId) {
        return repo.getById(compraId);
    }

    @Override
    public List<ElasticCompra> searchByFechaExacto(String fecha) {
        return repo.searchByFecha(fecha);
    }

    @Override
    public List<ElasticCompra> searchByFactura(String factura) {
        return repo.searchByFactura(factura);
    }

    @Override
    public List<ElasticCompra> searchByFacturaExacto(String factura) {
        return repo.searchByFacturaExacto(factura);
    }

    @Override
    public List<ElasticCompra> getAvailableCompras() {
        Iterable<ElasticCompra> compras= repo.getAll();
        List<ElasticCompra> p = new ArrayList<>();
        for(ElasticCompra compra: compras){
            p.add(compra);
        }
        return p;
    }
}
