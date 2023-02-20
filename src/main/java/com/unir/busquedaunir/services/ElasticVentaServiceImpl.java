package com.unir.busquedaunir.services;


import com.unir.busquedaunir.entities.ElasticCompra;
import com.unir.busquedaunir.entities.ElasticProducto;
import com.unir.busquedaunir.entities.ElasticVenta;
import com.unir.busquedaunir.models.request.CreateVentaRequest;
import com.unir.busquedaunir.repositories.ElasticsearchVentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ElasticVentaServiceImpl implements ElasticVentaService {
    private final ElasticsearchVentaRepository repo;

    @Override
    public ElasticVenta createVenta(CreateVentaRequest request) {
        if (request != null && StringUtils.hasLength(( request.getFecha().toString()))
                && (request.getProductos().size()>0)
        ) {

            ElasticVenta compra =
                    ElasticVenta.builder().id(request.getId())
                            .fecha(request.getFecha()).numeroFactura(request.getNumeroFactura()).total(request.getTotal())
                            .cliente_id(request.getCliente_id())
                            .productos(request.getProductos()).build();

            return repo.saveVenta(compra);
        } else {
            return null;
        }
    }

    @Override
    public ElasticVenta getVentaById(String ventaId) {
        return repo.getById(ventaId);
    }

    @Override
    public List<ElasticVenta> searchByFechaExacto(String fecha) {
        return repo.searchByFecha(fecha);
    }

    @Override
    public List<ElasticVenta> searchByFactura(String factura) {
        return repo.searchByFactura(factura);
    }

    @Override
    public List<ElasticVenta> searchByFacturaExacto(String factura) {
        return repo.searchByFacturaExacto(factura);
    }

    @Override
    public List<ElasticVenta> getAvailableVentas() {
        Iterable<ElasticVenta> ventas= repo.getAll();
        List<ElasticVenta> p = new ArrayList<>();
        for(ElasticVenta venta: ventas){
            p.add(venta);
        }
        return p;
    }
}
